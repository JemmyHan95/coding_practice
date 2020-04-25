import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[11];
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < array.length; i++) {
            int input = scanner.nextInt();
            array[i] = input;
        }
        // Selection<Integer> sel = new Selection<Integer>();
        // sel.sort(array);
        // sel.display(array);
        // Insertion<Integer> ins = new Insertion<Integer>();
        // ins.sort(array);
        // ins.display(array);
        // Shell<Integer> she = new Shell<Integer>();
        // she.sort(array);
        // she.display(array);
        // Merge<Integer> mer = new Merge<Integer>();
        // mer.sort(array);
        // mer.display(array);
        // Quick<Integer> qui = new Quick<Integer>();
        // qui.sort(array);
        // qui.display(array);
        Heap<Integer> heap = new Heap<Integer>();
        heap.sort(array);
        heap.display(array);
        scanner.close();
    }
}