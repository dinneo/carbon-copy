/*
 *
 *  Copyright 2017 Marco Helmich
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.carbon.copy.data.structures;

import com.google.inject.Inject;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TxnManagerTest extends GalaxyBaseTest {

    @Inject
    private InternalDataStructureFactory dsFactory;

    @Inject
    private TxnManager txnManager;

    @Test
    public void testBasicTransaction() throws Exception {
        int count = 100;
        Map<String, String> map = new HashMap<>();
        AtomicLong id = new AtomicLong(-1L);

        txnManager.doTransactionally(txn -> {
            DataBlock<String, String> db = dsFactory.newDataBlock(txn);
            for (int i = 0; i < count; i++) {
                String key = UUID.randomUUID().toString();
                String value = UUID.randomUUID().toString();

                map.put(key, value);
                db.put(key, value, txn);
                id.set(db.getId());
            }
        });

        DataBlock<String, String> db = dsFactory.loadDataBlock(id.get());
        map.forEach((key, value) -> assertEquals(value, db.get(key)));
    }

    @Test(expected = IOException.class)
    public void testChangingExistingHash() throws Exception {
        AtomicLong id = new AtomicLong(-1L);

        txnManager.doTransactionally(txn -> {
            DataBlock<Integer, String> db = dsFactory.newDataBlock(txn);
            for (int i = 0; i < 10; i++) {
                String value = UUID.randomUUID().toString();

                db.put(i, value, txn);
                id.set(db.getId());
            }
            throw new RuntimeException("BOOOOM -- this has been planted for your test");
        });

        DataBlock<Integer, String> db = dsFactory.loadDataBlock(id.get());
        assertNull(db.get(7));
        assertNull(db.get(3));
        assertNull(db.get(5));
    }
}
