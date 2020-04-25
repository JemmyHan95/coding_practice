public class RedBlackTreeST<Key extends Comparable<Key>, Value> extends AbstractOrderedSymbolTable<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        int N;

        Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private Node root;

    private boolean isRed(Node x) {
        return x.color;
    }

    public int size(Node h) {
        return h.N;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = true;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColor(Node h) {
        h.color = true;
        h.left.color = false;
        h.right.color = false;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = false;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, true);
        }

        int cmp = h.key.compareTo(key);
        if (cmp < 0) {
            h.right = put(h.right, key, value);
        } else if (cmp > 0) {
            h.left = put(h.left, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.right) && isRed(h.left)) {
            flipColor(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }
}