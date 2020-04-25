public class Quick<T> extends Base<T> {
    private Insertion<T> ins;

    public Quick() {
        super();
        ins = new Insertion<T>();
    }

    @Override
    public void sort(Comparable<T>[] a) {
        int N = a.length - 1;
        quickSort(a, 0, N);
    }

    private void quickSort(Comparable<T>[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        if (high <= low + 2) {
            ins.sort(a, low, high);
            return;
        }
        int pos = partition(a, low, high);
        quickSort(a, low, pos - 1);
        quickSort(a, pos + 1, high);
    }

    @SuppressWarnings("unchecked")
    private int partition(Comparable<T>[] a, int low, int high) {
        int pivot = low;
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while ((i <= j) && (a[i].compareTo((T) a[pivot]) < 0)) {
                i++;
            }
            while ((i <= j) && (a[j].compareTo((T) a[pivot]) > 0)) {
                j--;
            }
            if (i > j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, j, pivot);

        return j;
    }
}