import java.util.Arrays;

public class L1502_canArthmProgrs {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; ++i) {
            if ((arr[i + 1] - arr[i]) != (arr[i + 2] - arr[i + 1])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr1 = { 3, 5, 1 };
        int[] arr2 = { 1, 2, 4 };
        int[] arr3 = { 0, 0, 0, 0 };
        int[] arr4 = { 1, 100 };
        int[] arr5 = { 13, 12, -12, 9, 9, 16, 7, -10, -20, 0, 18, -1, -20, -10, -8, 15, 15, 16, 2, 15 };
        int[] arr6 = { 1, 10, 10, 10, 19 };

        System.out.println("return1: " + canMakeArithmeticProgression(arr1)); // true
        System.out.println("return2: " + canMakeArithmeticProgression(arr2)); // false
        System.out.println("return3: " + canMakeArithmeticProgression(arr3)); // true
        System.out.println("return4: " + canMakeArithmeticProgression(arr4)); // true
        System.out.println("return5: " + canMakeArithmeticProgression(arr5)); // false
        System.out.println("return6: " + canMakeArithmeticProgression(arr6)); // false

    }
}
