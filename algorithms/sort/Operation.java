public interface Operation<T> {
    public void exch(Comparable<T>[] a, int i, int j);
    public void sort(Comparable<T>[] a);
    public void display(Comparable<T>[] a);
}