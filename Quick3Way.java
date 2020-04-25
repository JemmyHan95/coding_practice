import java.util.Scanner;

public class Quick3Way {
    private static void helper(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int v = a[low], lt = low, i = lt + 1, gt = high, tmp = 0;
        while (i <= gt) {
            if (a[i] < v) {
                tmp = a[i];
                a[i] = a[lt];
                a[lt] = tmp;
                lt++;
            } else if (a[i] > v) {
                tmp = a[i];
                a[i] = a[gt];
                a[gt] = tmp;
                gt--;
            } else {
                i++;
            }
        }
        helper(a, low, lt - 1);
        helper(a, gt + 1, high);
    }

    private static void sort(int[] a) {
        int N = a.length;
        System.out.println(N);
        helper(a, 0, N - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];//{9, 7, 6, 5, 3, 5, 4, 5, 5, 1}
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + ' ');
        }
        System.out.println();
        sort(a);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + ' ');
        }
        System.out.println();
        sc.close();
    }
}