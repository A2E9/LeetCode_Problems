/**
 * L191_hamminWeight
 */
public class _L191_hamminWeight {

    public static int hammingWeight(int n) {
        char[] binary = Integer.toBinaryString(n).toCharArray();
        // String binary = Integer.toBinaryString(n);
        int count = 0;
        // int binLength = binary.length();

        for (char c : binary)
            if (c == '1')
                count++;

        // for (int i = 0; i < binary.length; i++) {
        // if(binary[i]=='1'){
        // count++;
        // }
        // }

        // System.out.println(count);

        // for (int i = 0; i < binLength; i++)
        // if (binary.charAt(i) == '1')
        // count++;

        return count;
    }

    public static void main(String[] args) {
        hammingWeight(-3);
    }
}