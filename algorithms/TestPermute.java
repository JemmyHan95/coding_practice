import java.util.List;

public class TestPermute {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};
        Permute p1 = new Permute();
        for (List<Integer> track : p1.permute(num1)) {
            for (Integer n : track) {
                System.out.print(n + ",");
            }
            System.out.println();
        }
    }
}
