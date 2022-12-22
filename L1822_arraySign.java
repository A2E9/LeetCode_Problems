public class L1822_arraySign {

    public static int arraySign(int[] nums) {
        int countMinus = 0;

        for (int i : nums) {
            if (i < 0)
                countMinus++;
            if (i == 0)
                return 0;
        }

        if ((countMinus % 2) == 0)
            return 1;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 1, -1, 1, -1 };
        int[] arr1 = { 41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82,
                70, 15, -41 };
        int[] arr2 = { 9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24 };
        int[] arr3 = { -1, -2, -3, -4, 3, 2, 1 };

        System.out.println("return0: " + arraySign(arr));
        System.out.println("return1: " + arraySign(arr1));
        System.out.println("return2: " + arraySign(arr2));
        System.out.println("return3: " + arraySign(arr3));
    }
}

// 41* 65* 14* 80* 20* 10* 55* 58* 24* 56* 28* 86* 96* 10* 3* 84* 4* 41
// 9*72*34*29*-49*-22*-77*-17*-66*-75*-44*-30*-24