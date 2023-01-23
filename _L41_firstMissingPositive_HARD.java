public class _L41_firstMissingPositive_HARD {
    public static int firstMissingPositive(int[] nums) {
        // 0 1 2 3 4 5 6 7 8 9
        // 1 3 6 10 15 21 28 36 45
        // 2 3 4 5 6 7 8 9
        // Exclude 0
        // check the smallest
        // sort nums
        // Check: add 1 and if it is consequentive

        int count = 0;
        if (nums[0] >= 0) {
            for (int i = nums[0]; i < nums.length; i++) {
                if (i == nums[i]) {
                    count++;
                } else {
                    return 1;
                }
            }
        } else {
            for (int i = nums[0]; i < nums.length;) {
                if (i >= 0) {
                    i++;
                }
                if (i == nums[Math.abs(i)]) {
                    count++;
                    i--;
                } else {
                    return 1;
                }
            }
        }

        System.out.println("count: " + count);

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2 };
        int[] nums2 = { -1, -2, 0, 1, 2 };
        System.out.println("return: " + firstMissingPositive(nums));
        System.out.println("return: " + firstMissingPositive(nums2));

    }
}
