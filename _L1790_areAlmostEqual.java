import java.util.Arrays;

public class _L1790_areAlmostEqual {
    public static boolean areAlmostEqual(String s1, String s2) {

        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");

        // check from first arr1 how much arr1[i] are same with arr2[i]
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].equals(arr2[i])) {
                count++;
            }
        }

        if (arr1.length - count == 2 || arr1.length - count == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {

        System.out.println(areAlmostEqual("ankb", "bank"));

    }
}
