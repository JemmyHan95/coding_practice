public class Insertion<T> extends Base<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1].compareTo((T) a[j]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1].compareTo((T) a[j]) > 0) {
                    exch(a, j, j - 1);
                }
            }
        }
    }
}