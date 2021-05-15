import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Permute {
    private List<List<Integer>> result;

    public Permute() {
        result = new ArrayList<>();
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(nums, track);

        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
