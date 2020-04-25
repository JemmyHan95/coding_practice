class AnotherSolution {
    public int thirdMax(int[] nums) {
        Long m1 = null, m2 = null, m3 = null;
        for (int i = 0; i < nums.length; i++) {
            if (m1 == null || m1.longValue() <= nums[i]) {
                m1 = (Integer)nums[i];
            } else if (m2 == null || m2.longValue() <= nums[i]) {
                m2 = (Integer)nums[i];
            } else if (m3 == null || m3.longValue() <= nums[i]) {
                m3 = (Integer)nums[i];
            }
        }
        if (m3 != null) {
            return m3.longValue();
        } else {
            return m1.longValue();
        }
    }
}