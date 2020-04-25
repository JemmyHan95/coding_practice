import java.util.Iterator;

public class SequentialSearchST<Key, Value> extends AbstractSymbolTable<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node first;

    public Value get(Key key) {
        for (Node t = first; t != null; t = t.next) {
            if (key.equals(t.key)) {
                return t.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node t = first; t != null; t = t.next) {
            if (key.equals(t.key)) {
                t.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public int size() {
        int size = 0;
        for (Node t = first; t != null; t = t.next) {
            size++;
        }
        return size;
    }

    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private Node current = first;

                    @Override
                    public boolean hasNext() {
                        return current.next == null;
                    }

                    @Override
                    public Key next() {
                        Key key = null;
                        if (current != null) {
                            key = current.key;
                            current = current.next;
                        }
                        return key;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}