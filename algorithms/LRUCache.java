import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    private void makeRecently(int key) {
        Node n = map.get(key);
        cache.remove(n);
        cache.addTail(n);
    }

    private void addRecently(int key, int val) {
        Node n = new Node(key, val);
        cache.addTail(n);
        map.put(key, n);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node delN = cache.removeFirst();
        int delKey = delN.getKey();
        map.remove(delKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).getVal();
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }

        if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }
}

class Node {
    private int key, val;
    private Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }

    public int getKey() {
        return this.key;
    }

    public int getVal() {
        return this.val;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    public void addTail(Node n) {
        n.setPrev(tail.getPrev());
        n.setNext(tail);
        tail.getPrev().setNext(n);
        tail.setPrev(n);
        size++;
    }

    public void remove(Node n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
    }

    public Node removeFirst() {
        if (head.getNext() == tail) {
            return null;
        }
        Node first = head.getNext();
        remove(first);

        return first;
    }

    public int size() {
        return size;
    }
}

