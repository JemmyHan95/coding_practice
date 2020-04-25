public class Heap<T> extends Base<T> {

    @SuppressWarnings("unchecked")
    private void swim(Comparable<T>[] a, int k) {
        while (k > 1 && (a[k].compareTo((T)a[k / 2]) < 0)) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    @SuppressWarnings("unchecked")
    private void sink(Comparable<T>[] a, int k, int N) {
        while (2 * k <= N) {
            int t = 2 * k;
            if (t < N && (a[t + 1].compareTo((T)a[t]) > 0)) {
                t++;
            }
            if (a[t].compareTo((T)a[k]) > 0) {
                exch(a, t, k);
                k = t;
            } else {
                break;
            }
        }
    }

    @Override
    public void sort(Comparable<T>[] a) {
        int N = a.length - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(a, i, N);
        }
        while (N > 1) {
            exch(a, 1, N);
            N--;
            sink(a, 1, N);
        }
    }
}