public class MonotonicQueue<E extends Comparable> {
    private LinkedList<E> queue;
        
        public MonotonicQueue() {
            queue = new LinkedList<E>();
        }
        
        public void push(E e) {
            while (!queue.isEmpty() && queue.getLast().compareTo(e) < 0) {
                queue.pollLast();
            }
            queue.addLast(e);
        }
        
        public E max() {
            return queue.getFirst();
        }
        
        public void pop(E e) {
            if (queue.getFirst().equals(e)) {
                queue.pollFirst();
            }
        }
}
