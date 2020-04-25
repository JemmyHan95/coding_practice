public class Shell<T> extends Base<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo((T) a[j - h]) < 0; j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}