import java.util.Arrays;

public class L1_twoSum {

    public static int[] twoSum(int[] nums, int target) {
        int indx[] = new int[2];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(((target - nums[j]) == nums[i]) && i != j){
                    indx[0] = i;
                    indx[1] = j;
                    return indx;
                }
            }
        }
        return indx;
    }

    public static void main(String[] args) {
        int arr[] = { 2,5,5,11};
        System.out.println(Arrays.toString(twoSum(arr, 10))); 
    }
}
