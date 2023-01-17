public class L202_isHappy {
    //Java Time beats up 97% 1ms-3ms, Memory beats 8% - 92%
    //commented takes 3-4ms
    public static boolean isHappy(int n) {
        int nLength = String.valueOf(n).length();
        int[] numArr = 
        // new int[nLength];
        // if (nLength == 1)
        //     numArr[0] = n;
        // else
        //     numArr = 
            intToArray(n, nLength);

        int digit = 0;
        // int digitLength = 0;

        for (int i = 0; digit != 1; i++) {
            for (int j = 0; j < numArr.length; j++)
                digit += Math.pow(numArr[j], 2);

            // digitLength = String.valueOf(digit).length();

            // if (digitLength == 1) {
            //     numArr = new int[digitLength];
            //     numArr[0] = digit;
            // } else
                numArr = intToArray(digit, String.valueOf(digit).length());
            if (digit == 1)
                return true;
            if (20 == digit && i > 1)
                return false;
            digit = 0;
        }

        return false;
    }

    public static int[] intToArray(int n, int arrLength) {
        int[] numArr = new int[arrLength];
        int i = 0;
        while (n != 0) {
            numArr[i] = n % 10;
            n /= 10;
            i++;
        }
        return numArr;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(22));
    }
}

// /**
// * @param {number} n
// * @return {boolean}
// */
// var isHappy = function(n) {
// var digits = [];
// while (n > 0) {
// digits.push(n % 10);
// n = Math.trunc(n / 10);
// }
// digits.reverse();
// digits.map((digit) => {
// console.log(Math.pow(digit, 2))
// })
// };