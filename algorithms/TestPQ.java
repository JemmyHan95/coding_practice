public class TestPQ {
    public static void main(String[] args) {
        MaxPQ<Integer> maxPqInt = new MaxPQ<Integer>(10);
        maxPqInt.insert(5);
        maxPqInt.insert(8);
        maxPqInt.insert(3);
        maxPqInt.insert(9);
        maxPqInt.insert(10);
        maxPqInt.insert(4);
        maxPqInt.insert(2);
        maxPqInt.insert(1);
        maxPqInt.insert(7);
        System.out.println(maxPqInt.deleteMax());
        System.out.println(maxPqInt.deleteMax());
        System.out.println(maxPqInt.deleteMax());
        System.out.println(maxPqInt.deleteMax());
        System.out.println(maxPqInt.deleteMax());
    }
}
