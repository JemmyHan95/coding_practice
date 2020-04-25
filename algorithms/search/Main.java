public class Main {
    public static void main(String[] args) {
        BinarySearchTreeST<Integer, String> bst = new BinarySearchTreeST<Integer, String>();
        bst.put(1, "Hello");
        bst.put(2, "World");
        bst.put(3, "Java");
        bst.put(4, "Algorithm");
        bst.put(8, "Search");
        bst.put(5, "Sort");
        bst.put(7, "Range");
        System.out.println(bst.get(1));
        System.out.println(bst.get(2));
        System.out.println(bst.get(8));
        System.out.println(bst.floor(9));
    }
}