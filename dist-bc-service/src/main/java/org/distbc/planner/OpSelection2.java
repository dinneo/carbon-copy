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

package org.distbc.planner;

import org.distbc.data.structures.GUID;
import org.distbc.data.structures.Table;
import org.distbc.data.structures.Tuple;
import org.distbc.parser.ParsingResult;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This is the old and manual way of evaluating an expression.
 * You shouldn't be using this anymore.
 * Use OpSelection instead.
 */
@Deprecated
class OpSelection2 implements Supplier<Set<GUID>> {
    private final List<ParsingResult.BinaryOperation> bos;
    private final Table tableToUse;

    OpSelection2(List<ParsingResult.BinaryOperation> bos, Table tableToUse) {
        this.bos = bos;
        this.tableToUse = tableToUse;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<GUID> get() {
        List<Tuple> tableMetadata = tableToUse.getColumnMetadata();
        // TODO -- we might want to filter this to only columns we need
        Map<String, Integer> columnNameToIndex = tableMetadata.stream()
                .collect(Collectors.toMap(tuple -> (String)tuple.get(0), tuple -> (Integer)tuple.get(1)));

        Predicate<Tuple> p = tuple -> {
            AtomicBoolean b = new AtomicBoolean(false);
            bos.forEach(binaryOperation -> {
                Integer idx = columnNameToIndex.get(binaryOperation.operand1.toUpperCase());
                if (idx != null) {
                    int cmp = tuple.get(idx).compareTo(binaryOperation.operand2);
                    switch(binaryOperation.operation) {
                        case "=":
                            b.getAndSet(cmp == 0);
                            break;
                        case ">":
                            b.getAndSet(cmp > 0);
                            break;
                        case ">=":
                            b.getAndSet(cmp >= 0);
                            break;
                        case "<":
                            b.getAndSet(cmp < 0);
                            break;
                        case "<=":
                            b.getAndSet(cmp <= 0);
                            break;
                        case "<>":
                            b.getAndSet(cmp != 0);
                            break;
                        default:
                            throw new IllegalArgumentException("Couldn't parse comparator " + binaryOperation.operation);
                    }
                } else {
                    throw new IllegalArgumentException("Couldn't find column " + binaryOperation.operand1);
                }
            });
            // if this return true, the record is being kept in the result set
            // if this returns false, the record will be deleted from the result set
            return b.get();
        };

        // do the actual selection
        return tableToUse.keys()
                .map(tableToUse::get)
                .filter(p)
                .map(Tuple::getGuid)
                .collect(Collectors.toSet());
    }
}