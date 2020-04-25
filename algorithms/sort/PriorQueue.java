public class PriorQueue {
    private int[] heap;
    private int length;
    private int index;

    public PriorQueue() {
        heap = new int[11];
        length = 10;
        index = 1;
    }

    public PriorQueue(int N) {
        heap = new int[N + 1];
        length = N;
        index = 1;
    }

    private void exch(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && (heap[k] < heap[k / 2])) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < length) {
            int t = 2 * k;
            if (heap[t + 1] > heap[t]) {
                t++;
            }
            if (heap[t] > heap[k]) {
                exch(t, k);
                k = t;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return index == 1;
    }

    public int size() {
        return length;
    }

    public void insert(int e) {
        if (index > length) {
            System.out.println("Heap is full!");
            return;
        }
        heap[index] = e;
        swim(index);
        index++;
    }

    public int delHead() {
        int head = heap[1];
        exch(1, index - 1);
        sink(1);
        index--;

        return head;
    }
}