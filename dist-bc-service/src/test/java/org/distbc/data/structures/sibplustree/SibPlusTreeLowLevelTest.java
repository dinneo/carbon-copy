package org.distbc.data.structures.sibplustree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SibPlusTreeLowLevelTest {
    private int leafNodeSize = 3;
    private int numberOfNodesInLeafNodeGroup = 3;
    private String prefix = "narf_";

    @Test
    public void testDoHighKeyBusiness() {
        SibPlusTree<Integer, String> t = new SibPlusTree<>(leafNodeSize, numberOfNodesInLeafNodeGroup);

        List<Breadcrumb<Integer>> breadcrumbs = new ArrayList<>();

        InternalNodeGroup<Integer> ing1 = t.newInternalNodeGroup(2);
        InternalNodeGroup<Integer> ing2 = t.newInternalNodeGroup(1);
        LeafNodeGroup<Integer, String> lng = t.newLeafNodeGroup();

        lng.put(NodeIdxAndIdx.of(0, 2), 99, UUID.randomUUID().toString());
        lng.put(NodeIdxAndIdx.of(1, 2), 111, UUID.randomUUID().toString());
        lng.put(NodeIdxAndIdx.of(2, 2), 222, UUID.randomUUID().toString());

        ing1.setChildNodeOnNode(1, ing2);
        ing2.setChildNodeOnNode(0, lng);

        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(0, 1)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(0, 0)));

        NodeIdxAndIdx insertionIdx = NodeIdxAndIdx.of(0, 2);
        NodeIdxAndIdx emptyIdx = NodeIdxAndIdx.of(0, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        insertionIdx = NodeIdxAndIdx.of(2, 2);
        emptyIdx = NodeIdxAndIdx.of(2, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertEquals(Integer.valueOf(222), ing1.getKey(0, 1));
        assertEquals(Integer.valueOf(99), ing2.getKey(0, 0));
        assertEquals(Integer.valueOf(111), ing2.getKey(0, 1));

        ///////////////////////////////////////
        /////////////////////////////
        //////////////////
        // second case
        breadcrumbs.clear();

        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(0, 0)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(0, 1)));

        insertionIdx = NodeIdxAndIdx.of(1, 2);
        emptyIdx = NodeIdxAndIdx.of(1, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertEquals(Integer.valueOf(222), ing1.getKey(0, 1));
        assertEquals(Integer.valueOf(99), ing2.getKey(0, 0));
        assertEquals(Integer.valueOf(111), ing2.getKey(0, 1));

        ///////////////////////////////////////
        /////////////////////////////
        //////////////////
        // third case
        breadcrumbs.clear();

        ing1 = t.newInternalNodeGroup(1);
        ing1.setChildNodeOnNode(1, lng);
        ing2 = t.newInternalNodeGroup(2);
        ing2.setChildNodeOnNode(1, ing1);
        InternalNodeGroup<Integer> ing3 = t.newInternalNodeGroup(3);
        ing3.setChildNodeOnNode(0, ing2);

        breadcrumbs.add(Breadcrumb.of(ing3, NodeIdxAndIdx.of(0, 0)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(1, 1)));

        insertionIdx = NodeIdxAndIdx.of(2, 2);
        emptyIdx = NodeIdxAndIdx.of(2, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertNull(ing1.getKey(0, 1));
        assertNull(ing2.getKey(0, 0));
        assertEquals(Integer.valueOf(222), ing2.getKey(1, 1));
    }

    @Test
    public void testFourLevels() {
        SibPlusTree<Integer, String> t = new SibPlusTree<>(leafNodeSize, numberOfNodesInLeafNodeGroup);

        InternalNodeGroup<Integer> ing4 = t.newInternalNodeGroup(4);
        InternalNodeGroup<Integer> ing3 = t.newInternalNodeGroup(3);
        InternalNodeGroup<Integer> ing2 = t.newInternalNodeGroup(2);
        InternalNodeGroup<Integer> ing1 = t.newInternalNodeGroup(1);
        LeafNodeGroup<Integer, String> lng = getFullLeafNodeGroup(t);

        ing1.setChildNodeOnNode(1, lng);
        ing2.setChildNodeOnNode(1, ing1);
        ing3.setChildNodeOnNode(1, ing2);
        ing4.setChildNodeOnNode(1, ing3);

        ///////////////////////////////////////
        /////////////////////////////
        //////////////////
        // first case
        List<Breadcrumb<Integer>> breadcrumbs = new ArrayList<>(4);
        breadcrumbs.add(Breadcrumb.of(ing3, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(1, 0)));
        NodeIdxAndIdx insertionIdx = NodeIdxAndIdx.of(0, 2);
        NodeIdxAndIdx emptyIdx = NodeIdxAndIdx.of(0, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertEquals(Integer.valueOf(6), ing1.getKey(NodeIdxAndIdx.of(1, 0)));
        assertEquals(Integer.valueOf(15), ing1.getKey(NodeIdxAndIdx.of(1, 1)));
        assertEquals(Integer.valueOf(24), ing2.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing3.getKey(NodeIdxAndIdx.of(1, 1)));

        ///////////////////////////////////////
        /////////////////////////////
        //////////////////
        // second case
        breadcrumbs.clear();
        breadcrumbs.add(Breadcrumb.of(ing4, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing3, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(1, 2)));
        insertionIdx = NodeIdxAndIdx.of(2, 2);
        emptyIdx = NodeIdxAndIdx.of(2, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertEquals(Integer.valueOf(6), ing1.getKey(NodeIdxAndIdx.of(1, 0)));
        assertEquals(Integer.valueOf(15), ing1.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing2.getKey(NodeIdxAndIdx.of(1, 0)));
        assertEquals(Integer.valueOf(24), ing2.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing3.getKey(NodeIdxAndIdx.of(1, 0)));
        assertNull(ing3.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing4.getKey(NodeIdxAndIdx.of(1, 1)));
    }

    @Test
    public void testFourLevelsColdStart() {
        SibPlusTree<Integer, String> t = new SibPlusTree<>(leafNodeSize, numberOfNodesInLeafNodeGroup);

        InternalNodeGroup<Integer> ing4 = t.newInternalNodeGroup(4);
        InternalNodeGroup<Integer> ing3 = t.newInternalNodeGroup(3);
        InternalNodeGroup<Integer> ing2 = t.newInternalNodeGroup(2);
        InternalNodeGroup<Integer> ing1 = t.newInternalNodeGroup(1);
        LeafNodeGroup<Integer, String> lng = getFullLeafNodeGroup(t);

        ing1.setChildNodeOnNode(1, lng);
        ing2.setChildNodeOnNode(1, ing1);
        ing3.setChildNodeOnNode(1, ing2);
        ing4.setChildNodeOnNode(1, ing3);

        List<Breadcrumb<Integer>> breadcrumbs = new ArrayList<>(4);
        breadcrumbs.add(Breadcrumb.of(ing4, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing3, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing2, NodeIdxAndIdx.of(1, 1)));
        breadcrumbs.add(Breadcrumb.of(ing1, NodeIdxAndIdx.of(1, 2)));
        NodeIdxAndIdx insertionIdx = NodeIdxAndIdx.of(2, 2);
        NodeIdxAndIdx emptyIdx = NodeIdxAndIdx.of(2, 2);
        t.doHighKeyBusiness(breadcrumbs, insertionIdx, emptyIdx);

        assertNull(ing1.getKey(NodeIdxAndIdx.of(1, 0)));
        assertNull(ing1.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing2.getKey(NodeIdxAndIdx.of(1, 0)));
        assertEquals(Integer.valueOf(24), ing2.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing3.getKey(NodeIdxAndIdx.of(1, 0)));
        assertNull(ing3.getKey(NodeIdxAndIdx.of(1, 1)));
        assertNull(ing4.getKey(NodeIdxAndIdx.of(1, 0)));
        assertNull(ing4.getKey(NodeIdxAndIdx.of(1, 1)));
    }

    private LeafNodeGroup<Integer, String> getFullLeafNodeGroup(SibPlusTree<Integer, String> t) {
        LeafNodeGroup<Integer, String> lng = t.newLeafNodeGroup();
        NodeIdxAndIdx p = NodeIdxAndIdx.of(0, 0);
        while (!NodeIdxAndIdx.INVALID.equals(p)) {
            assertEquals(p, lng.findClosestEmptySlotFrom(p));
            lng.put(p, ((p.nodeIdx * leafNodeSize) + p.idx) * 3, prefix + p.toString());
            assertEquals(p, lng.findClosestFullSlotFrom(p));
            p = lng.plusOne(p);
        }

        assertEquals(NodeIdxAndIdx.INVALID, lng.findClosestEmptySlotFrom(NodeIdxAndIdx.of(0, 0)));
        return lng;
    }
}