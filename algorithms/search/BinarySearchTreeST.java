import java.util.Queue;
import java.util.ArrayDeque;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value> extends AbstractOrderedSymbolTable<Key, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N; // The number of nodes in the tree

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.N;
        }
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp == 0) {
            return n.value;
        } else if (cmp < 0) {
            return get(n.left, key);
        } else {
            return get(n.right, key);
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node n, Key key, Value value) {
        if (n == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(n.key);
        if (cmp == 0) {
            n.value = value;
        } else if (cmp < 0) {
            n.left = put(n.left, key, value);
        } else {
            n.right = put(n.right, key, value);
        }
        n.N = size(n.left) + size(n.right) + 1;
        /* iterative
        Node it = n, last = it;
        Stack<Node> trace = new Stack<Node>();
        while (it != null) {
            int cmpIt = key.compareTo(it.key);
            if (cmpIt == 0) {
                it.value = value;
                break;
            } else if (cmpIt < 0) {
                trace.push(it);
                last = it;
                it = it.left;
            } else {
                trace.push(it);
                last = it;
                it = it.right;
            }
        }
        if (it == null) {
            it = new Node(key, value, 1);
            int cmpN = last.key.compareTo(key);
            if (cmpN < 0) {
                last.right = it;
            } else {
                last.left = it;
            }
            while (!trace.isEmpty()) {
                Node prev = trace.pop();
                prev.N++;
            }
        }
        */
        return n;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    @Override
    public Key floor(Key key) {
        Node n = floor(root, key);
        if (n != null) {
            return n.key;
        } else {
            return null;
        }
    }

    private Node floor(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int cmp = n.key.compareTo(key);
        if (cmp == 0) {
            return n;
        }
        if (cmp > 0) {
            return floor(n.left, key);
        }
        Node r = floor(n.right, key);
        if (r != null) {
            return r;
        } else {
            return n;
        }
        /* iterative
        Node target = null;
        while (n != null) {
            int cmp = n.key.compareTo(key);
            if (cmp == 0) {
                target = n;
                break;
            }
            if (cmp > 0) {
                n = n.left;
                continue;
            }
            if (n.right != null) {
                int rCmp = n.right.key.compareTo(key);
                if (rCmp == 0) {
                    target = n.right;
                    break;
                } else if (rCmp > 0) {
                    target = n;
                    break;
                } else {
                    n = n.right;
                }
            } else {
                target = n;
                break;
            }
        }
        return target;
        */
    }

    @Override
    public Key ceiling(Key key) {
        Node n = ceiling(root, key);
        if (n != null) {
            return n.key;
        } else {
            return null;
        }
    }

    private Node ceiling(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int cmp = n.key.compareTo(key);
        if (cmp == 0) {
            return n;
        }
        if (cmp < 0) {
            return ceiling(n.right, key);
        }
        Node l = ceiling(n.left, key);
        if (l != null) {
            return l;
        } else {
            return n;
        }
        /* iterative
        Node target = null;
        while (n != null) {
            int cmp = n.key.compareTo(key);
            if (cmp == 0) {
                target = n;
                break;
            }
            if (cmp < 0) {
                n = n.right;
                continue;
            }
            if (n.left != null) {
                int rCmp = n.left.key.compareTo(key);
                if (rCmp == 0) {
                    target = n.left;
                    break;
                } else if (rCmp < 0) {
                    target = n;
                    break;
                } else {
                    n = n.left;
                }
            } else {
                target = n;
                break;
            }
        }
        return target;
        */
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node n, int k) {
        if (n == null) {
            return null;
        }
        int num = size(n.left);
        if (num == k) {
            return n.key;
        } else if (num > k) {
            return select(n.left, k);
        } else {
            return select(n.right, k - num - 1);
        }
        /* iterative
        Node p = n;
        Key target = null;
        while (p != null) {
            int num = size(n.left);
            if (num == k) {
                target = n.key;
                break;
            } else if (num > k) {
                p = p.left;
            } else {
                p = p.right;
                k = k - num - 1;
            }
        }
        return target
        */
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node n, Key key) {
        if (n == null) {
            return 0;
        }
        int cmp = n.key.compareTo(key);
        if (cmp == 0) {
            return size(n.left);
        } else if (cmp < 0) {
            return rank(n.right, key) + size(n.left) + 1;
        } else {
            return rank(n.left, key);
        }
        /* iterative
        Node p = n;
        int result = 0;
        while (p != null) {
            int cmp = p.key.compareTo(key);
            if (cmp == 0) {
                result = size(p.left);
                break;
            } else if (cmp < 0) {
                result = result + size(p.left) + 1;
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return result;
        */
    }

    @Override
    public void deleteMax() {
        // Node p = root, q = p;
        // while (p != null && p.right != null) {
        //     q = p;
        //     p = p.right;
        // }
        // q.right = p.left;
        root = deleteMax(root);
    }

    private Node deleteMax(Node n) {
        if (n.right == null) {
            return n.left;
        }
        n.right = deleteMax(n.right);
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }

    @Override
    public void deleteMin() {
        // Node p = root, q = p;
        // while (p != null && p.left != null) {
        //     q = p;
        //     p = p.left;
        // }
        // q.left = p.right;
        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = deleteMin(n.left);
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
        /* iterative
        Stack<Node> trace = new Stack<Node>();
        Node t = root;
        while (t != null) {
            int cmp = t.key.compareTo(key);
            if (cmp == 0) {
                break;
            } else if (cmp < 0) {
                trace.push(t);
                t = t.right;
            } else {
                trace.push(t);
                t = t.left;
            }
        }
        if (t == null) {
            return;
        }
        Node prev = trace.peek();
        Node tmp = null;
        if (t.left == null) {
            int cmp = prev.key.compareTo(t.key);
            if (cmp < 0) {
                prev.right = t.right;
            } else {
                prev.left = t.right;
            }
            while (!trace.isEmpty()) {
                tmp = trace.pop();
                tmp.N--;
            }
            return;
        }
        if (t.right == null) {
            int cmp = prev.key.compareTo(t.key);
            if (cmp < 0) {
                prev.right = t.left;
            } else {
                prev.left = t.left;
            }
            while (!trace.isEmpty()) {
                tmp = trace.pop();
                tmp.N--;
            }
            return;
        }
        tmp = t;
        t = min(tmp.right);
        t.left = tmp.left;
        t.right = deleteMin(tmp.right);
        while (!trace.isEmpty()) {
            tmp = trace.pop();
            tmp.N--;
        }
        */
    }

    private Node delete(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int cmp = n.key.compareTo(key);
        if (cmp < 0) {
            n.right = delete(n.right, key);
        } else if (cmp > 0) {
            n.left = delete(n.left, key);
        } else {
            if (n.left == null) {
                return n.right;
            }
            if (n.right == null) {
                return n.left;
            }
            Node t = n;
            n = min(t.right);
            n.left = t.left;
            n.right = deleteMin(t.right);
        }
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> que = new ArrayDeque<Key>();
        keys(root, que, lo, hi);
        return que;
        /* iterative
        Stack<Node> st = new Stack<Node>();
        Node t = null;
        st.push(root);

        while (!st.isEmpty()) {
            t = st.peek();
            if (t == NULL) {
                st.pop();
                continue;
            }
            int cmpl = lo.compareTo(t.key);
            int cmph = hi.compareTo(t.key);
            if (cmpl < 0 && !st.contains(t.left)) {
                st.push(t.left);
                continue;
            }
            if (cmpl <= 0 && cmph >= 0) {
                que.add(t.key);
                continue;
            }
            if (cmph > 0 && !st.contains(t.right)) {
                st.push(t.right);
                continue;
            }
            st.pop();
        }

        return que;
        */
    }

    private void keys(Node n, Queue<Key> que, Key lo, Key hi) {
        if (n == null) {
            return;
        }
        int cmpl = lo.compareTo(n.key);
        int cmph = hi.compareTo(n.key);
        if (cmpl < 0) {
            keys(n.left, que, lo, hi);
        }
        if (cmpl <= 0 && cmph >= 0) {
            que.add(n.key);
        }
        if (cmph > 0) {
            keys(n.right, que, lo, hi);
        }
    }
}