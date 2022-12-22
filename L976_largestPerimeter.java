import java.util.Arrays;

public class L976_largestPerimeter {
    public static int largestPerimeter(int[] nums) {

        // int a = 0, b = 1, c = 2, save = 0;
        // for (; c < nums.length; a++, b++, c++)
        // if (!((nums[a] + nums[b]) <= nums[c]))
        // save = nums[a] + nums[b] + nums[c];
        Arrays.sort(nums);
        for (int i = nums.length-1 ; i > 1; i--)
            if (nums[i] < (nums[i - 1] + nums[i - 2]))
                return nums[i - 2] + nums[i - 1] + nums[i];

        return 0;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 1, 2 };
        int[] nums2 = { 3, 2, 3, 4 };
        int[] nums3 = { 1, 2, 1 };
        System.out.println(largestPerimeter(nums));
        System.out.println(largestPerimeter(nums2));
        System.out.println(largestPerimeter(nums3));

    }
}
// 4367
// 3,2,3,4 10
// 3,6,2,3 8
// 1,2,1 0
// 2,1,2 5