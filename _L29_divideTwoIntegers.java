public class _L29_divideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0)
        return 0;
        if (divisor == 1)
            return dividend;
        int count = 0;
        String divisStr = "";
        String dividStr = "";
        String countStr = "";

        Boolean divisNegative = false;
        Boolean dividNegative = false;
        if (divisor == -2147483648) {
            divisor = 2147483647;
            divisNegative = true;
        } else if (divisor < 0) {
            divisStr = Integer.toString(divisor).replace('-', ' ').trim();
            divisor = Integer.parseInt(divisStr);
            divisNegative = true;
        }

         if (dividend == -2147483648) {
            dividend = 2147483647;
            dividNegative = true;
            if(divisor==1){
                return 2147483647;
            }
        } else if (dividend < 0) {
            dividStr = Integer.toString(dividend).replace('-', ' ').trim();
            dividend = Integer.parseInt(dividStr);
            dividNegative = true;
        }


        if (dividend < divisor)
            return 0;

        for (int i = divisor; i <= dividend; i += divisor) {
            // System.out.println(count++);
            count++;
        }
        if (divisNegative && dividNegative)
            return count;
        if (divisNegative || dividNegative) {
            countStr = "-".concat(Integer.toString(count));
            count = Integer.parseInt(countStr);
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(divide(-7, 3));
        // System.out.println(divide(7, -3));
        // System.out.println(divide(10, 3));
        // System.out.println(divide(-10, -3));
        // System.out.println(divide(1, 1));
        // System.out.println(divide(1, -1));
        // System.out.println(divide(-1, -1));
        // System.out.println(divide(1, 2));
        // System.out.println(divide(-1, -2147483648));
        System.out.println(divide(-2147483648, -1));
    }
}
