public class LruCache<T extends Comparable<T>> {
    private BidiNode<T> head;
    private BidiNode<T> tail;
    private BinarySearchST<BidiNode<T>, Integer> st;

    public LruCache() {
        BidiNode<T> tmp = new BidiNode<T>();
        head = tmp;
        tail = head;
        st = new BinarySearchST<BidiNode<T>, Integer>(10);
    }

    public T access(T t) {
        BidiNode<T> p = head;
        while (p != null && p != tail) {
            if (p.getData().equals(t)) {
                // Remove p from current position
                if (p.getPrev() != null) {
                    p.getPrev().setNext(p.getNext());
                }
                if (p.getNext() != null) {
                    p.getNext().setPrev(p.getPrev());
                }
                // Insert p into head
                p.setNext(head);
                head.setPrev(p);
                head = p;
                return p.getData();
            }
            p = p.getNext();
        }
        p = new BidiNode<T>(null, head, t);
        head.setPrev(p);
        head = p;

        return p.getData();
    }

    public T delete(T t) {
        BidiNode<T> p = head;
        while (p != null && p != tail) {
            if (p.getData().equals(t)) {
                // Remove p from current position
                if (p.getPrev() != null) {
                    p.getPrev().setNext(p.getNext());
                }
                if (p.getNext() != null) {
                    p.getNext().setPrev(p.getPrev());
                }
            }
            p = p.getNext();
        }
        return t;
    }
}

class BidiNode<T extends Comparable<T>> implements Comparable<BidiNode<T>> {
    private BidiNode<T> prev;
    private BidiNode<T> next;
    private T data;

    public BidiNode<T> getPrev() {
        return prev;
    }

    public void setPrev(BidiNode<T> prev) {
        this.prev = prev;
    }

    public BidiNode<T> getNext() {
        return next;
    }

    public void setNext(BidiNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BidiNode() {
        prev = null;
        next = null;
        data = null;
    }

    public BidiNode(BidiNode<T> prev, BidiNode<T> next, T data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    @Override
    public int compareTo(BidiNode<T> bidiNode) {
        return this.data.compareTo(bidiNode.getData());
    }
}
