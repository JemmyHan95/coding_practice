public class RedBlackTreeST<Key extends Comparable<Key>, Value> extends BinarySearchTreeST<Key, Value> {
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

    @Override
    public void delete(Key key) {
        // TODO
    }

    @Override
    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = true;
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = false;
        }
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }
        if (h.right == null) {
            return null;
        }
        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }
        h.right = deleteMax(h.right);

        return balance(h);
    }

    private Node moveRedRight(Node h) {
        flipColor(h);
        if (!isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = true;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = false;
        }
    }

    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }
    
    private Node moveRedLeft(Node h) {
        flipColor(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }
}