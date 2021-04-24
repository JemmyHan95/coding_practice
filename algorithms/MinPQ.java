public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MinPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key min() {
        return pq[1];
    }

    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    public Key deleteMin() {
        Key result = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);

        return result;
    }

    public void swim(int k) {
        while (k > 1 && more(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    public void sink(int k) {
        while (left(k) <= N) {
            int older = left(k);
            if (right(k) <= N && more(older, right(k))) {
                older = right(k);
            }
            if (more(older, k)) {
                break;
            }
            exch(k, older);
            k = older;
        }
    }

    private int parent(int k) {
        return k / 2;
    }

    private int left(int k) {
        return 2 * k;
    }

    private int right(int k) {
        return 2 * k + 1;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean more(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }
}
