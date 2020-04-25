public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    public Key min();
    public Key max();
    public Key floor(Key key);
    public Key ceiling(Key key);
    public int rank(Key key);
    public Key select(int k);
    public void deleteMin();
    public void deleteMax();
    public int size(Key lo, Key hi);
    public Iterable<Key> keys(Key lo, Key hi);
}