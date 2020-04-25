public class Merge<T> extends Base<T> {
    @Override
    public void sort(Comparable<T>[] a) {
        Object[] tmp = new Object[a.length];
        // int N = a.length - 1;
        // sortTopToBottom(a, tmp, 0, N);
        sortBottomToTop(a, tmp);
    }

    private void sortTopToBottom(Comparable<T>[] a, Object[] tmp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sortTopToBottom(a, tmp, low, mid);
        sortTopToBottom(a, tmp, mid + 1, high);
        merge(a, tmp, low, mid, high);
    }

    private void sortBottomToTop(Comparable<T>[] a, Object[] tmp) {
        int N = a.length;

        for (int st = 1; st < N; st = st + st) {
            for (int lo = 0; lo < N - st; lo = lo + st + st) {
                merge(a, tmp, lo, lo + st - 1, Math.min(lo + st + st - 1, N - 1));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(Comparable<T>[] a, Object[] tmp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tmp[i] = a[i];
        }
        int left = low, right = mid + 1;
        // while (left < mid && right < high) {
        //     if (tmp[left].compareTo((T) tmp[right]) < 0) {
        //         a[i] = tmp[left];
        //         left++;
        //     } else {
        //         a[i] = tmp[right];
        //         right++;
        //     }
        //     i++;
        // }
        // while (left < mid) {
        //     a[i] = tmp[left];
        //     left++;
        //     i++;
        // }
        // while (right < high) {
        //     a[i] = tmp[right];
        //     right++;
        //     i++;
        // }
        for (int k = low; k <= high; k++) {
            if (left > mid) {
                a[k] = (Comparable<T>) tmp[right];
                right++;
            } else if (right > high) {
                a[k] = (Comparable<T>) tmp[left];
                left++;
            } else if (((Comparable<T>)tmp[left]).compareTo((T) tmp[right]) < 0) {
                a[k] = (Comparable<T>) tmp[left];
                left++;
            } else {
                a[k] = (Comparable<T>) tmp[right];
                right++;
            }
        }
    }
}