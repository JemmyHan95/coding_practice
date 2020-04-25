class Solution {
    public int majorityElement(int[] nums) {
        int N = nums.length;
        sort(nums);
        int prev = nums[0];
        int repeat = 0;
        int majority = 0;
        for (int i = 1; i < N; i++) {
            if (nums[i] == prev) {
                repeat++;
                if (repeat > (N / 2)) {
                    majority = prev;
                    break;
                }
            } else {
                prev = nums[i];
                repeat = 0;
            }
        }
        return majority;
    }
    
    private void helper(int[] a, int low, int high) {
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

    private void sort(int[] a) {
        int N = a.length;
        System.out.println(N);
        helper(a, 0, N - 1);
    }
}