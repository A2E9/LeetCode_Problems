public class _L65_isNumber_HARD {
    public static boolean isNumber(String s) {

        


        return true;
    }

    public static void main(String[] args) {
        isNumber("e");

        // ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
        // "53.5e93", "-123.456e789"]

        // String s = ".";
        String sa = "-.9";

        // double a = Double.parseDouble(s);
        double b = Double.parseDouble(sa);

        System.out.println(b);
    }
}
