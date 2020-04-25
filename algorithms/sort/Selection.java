public class Selection<T> extends Base<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i].compareTo((T) a[j]) > 0) {
                    exch(a, i, j);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i + 1; j <= high; j++) {
                if (a[i].compareTo((T) a[j]) > 0) {
                    exch(a, i, j);
                }
            }
        }
    }
}