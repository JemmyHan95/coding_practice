import java.util.Queue;
import java.util.ArrayDeque;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends AbstractOrderedSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        N = capacity;
        keys = (Key[]) new Comparable[capacity + 1];
        values = (Value[]) new Object[capacity + 1];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i <= N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i <= N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
    }

    @Override
    public int rank(Key key) {
        return rank(key, 0, N);
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N];
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    @Override
    public void delete(Key key) {
        int pos = rank(key);
        for (int i = pos; i < N; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
    }

    @Override
    public boolean isEmpty() {
        if ((keys == null || keys.length == 0) && (values == null || values.length == 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new ArrayDeque<Key>();
        int low = rank(lo);
        int high = rank(hi);
        for (int i = low; i < high; i++) {
            q.add(keys[i]);
        }
        return q;
    }

    private int rank(Key key, int lo, int hi) {
        int mid = 0;
        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;
            int cmp = keys[mid].compareTo(key);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}