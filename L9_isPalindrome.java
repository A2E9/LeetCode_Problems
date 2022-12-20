public class L9_isPalindrome {

    public static boolean isPalindrome(int x) {

        String num = Integer.toString(x);
        int nLength = num.length();
        boolean isPal = true;
        int halfL = nLength / 2;
        for (int i = 0; i < halfL; i++) {
            if (num.charAt(i) != num.charAt((nLength - i) - 1)) {
                isPal = false;
            }
        }

        return isPal;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10111));

    }
}

// Check length of testcases idk

// if (((num.length() % 3) == 0)) {
// if (num.contains("-")) {
// return false;
// }else if(num.startsWith(Character.toString(num.charAt(num.length()-1)))){
// return true;
// }
// return false;
// } else if (num.length() == 1) {
// return true;
// } else if (num.charAt(0) == num.charAt(1)) {
// return true;
// }
// return false;
