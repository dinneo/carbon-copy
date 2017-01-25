package org.distbc.data.structures;

import java.util.Iterator;

public class DataBlock<Key extends Comparable<Key>, Value> extends DataStructure {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    DataBlock() {
        super();
    }

    DataBlock(long id) {
        super(id);
        load(this);
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key can't be null");
        Node x = first;
        while (x != null) {
            if (x.key.equals(key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key can't be null");
        currentObjectSize += sizeOfObject(key) + sizeOfObject(val);
        first = new Node(key, val, first);
    }

    public boolean putIfPossible(Key key, Value val) {
        int size = sizeOfObject(key) + sizeOfObject(val);
        if (isUnderMaxByteSize(size)) {
            put(key, val);
            return true;
        } else {
            return false;
        }
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key can't be null");

        if (key.equals(first.key)) {
            first = (first.next != null) ? first.next : null;
            return;
        }

        Node x = first;
        while (x != null) {
            if (x.next != null && x.next.key.equals(key)) {
                currentObjectSize -= sizeOfObject(key) + sizeOfObject(x.next.value);
                x.next = x.next.next;
                return;
            }
            x = x.next;
        }
    }

    Iterable<Key> keys() {
        return () -> new Iterator<Key>() {
            Node x = first;

            @Override
            public boolean hasNext() {
                return x != null;
            }

            @Override
            public Key next() {
                Node n = x;
                x = x.next;
                return n.key;
            }
        };
    }

    @Override
    void serialize(SerializerOutputStream out) {
        Node x = first;
        while (x != null) {
            out.writeObject(x.key);
            out.writeObject(x.value);
            x = x.next;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    void deserialize(SerializerInputStream in) {
        boolean shouldDoIt;
        do {
            Key key = (Key) in.readObject();
            Value value = (Value) in.readObject();
            shouldDoIt = key != null && value != null;
            if (shouldDoIt) first = new Node(key, value, first);
        } while (shouldDoIt);
    }

    @Override
    public int size() {
        int size = super.size();
        Node x = first;
        while (x != null) {
            size += sizeOfObject(x.key);
            size += sizeOfObject(x.value);
            x = x.next;
        }
        return size;
    }
}
