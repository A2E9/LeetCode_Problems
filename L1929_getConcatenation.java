import java.util.Arrays;

public class L1929_getConcatenation {
    public static int[] getConcatenation(int[] nums) {

        // int length = nums.length * 2;
        // int[] ans = new int[length];

        // for (int i = 0; i < nums.length; i++) {
        // ans[i] = nums[i];
        // ans[nums.length+i] = nums[i];
        // }

        System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(nums).replaceAll("\\[|\\]|\\s", ""));
        sb.append(Arrays.toString(nums).replaceAll("\\[|\\]|\\s", ""));
        System.out.println(sb.toString());
        // for (int i = 0; i < nums.length; i++) {
        //     sb.append(nums[i]);
        //     sb.append(nums[i]);
        // }
        // String[] res = sb.toString().split("");
        // int[] finalRes = new int[res.length];
        // for (int i = 0; i < res.length; i++) {
        //     finalRes[i] = Integer.parseInt(res[i]);
        // }
        return nums;

        // return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int[] nums1 = { 1, 3, 2, 1 };

        int[] nums2 = { 5,8,1,9,9,18,16,1,11,6,8,10 };
        
        System.out.println(Arrays.toString(getConcatenation(nums)));
        System.out.println(Arrays.toString(getConcatenation(nums1)));
        System.out.println(Arrays.toString(getConcatenation(nums2)));

    }
}
