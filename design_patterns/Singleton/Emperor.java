import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Emperor {
    private static int maxNum = 2;
    private static int currNum = 0;
    private static List<String> nameList = new ArrayList<String>();
    private static List<Emperor> emperorList = new ArrayList<Emperor>();

    private Emperor() {}
    private Emperor(String name) {
        nameList.add(name);
    }

    static {
        for (int i = 0; i < maxNum; i++) {
            emperorList.add(new Emperor("第" + i + "帝"));
        }
    }

    public static Emperor getInstance() {
        Random rand = new Random();
        int currNum = rand.nextInt(maxNum);

        return emperorList.get(currNum);
    }

    public String say() {
        return nameList.get(currNum);
    }
}