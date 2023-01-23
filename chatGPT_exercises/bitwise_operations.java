package chatGPT_exercises;

public class bitwise_operations {
    public static int AND_OP(int num1, int num2) {
        return num1 & num2;
    }

    public static int OR_OP(int num1, int num2) {
        return num1 | num2;
    }

    public static int XOR_OP(int num1, int num2) {
        return num1 ^ num2;
    }
    
    public static int NOT_OP(int num1) {
        return ~num1;
    }

    public static int LEFT_SHIFT(int num1, int num2) {
        return num1 << num2;
    }

    public static int RIGHT_SHIFT(int num1, int num2) {
        return num1 >> num2;
    }

    public static int RS_ZERO_FILL_OP(int num1, int num2) {
        return num1 >>> num2;
    }
   

    public static void main(String[] args) {

        int num1 = 12, num2 = 25, num4 = 1, rs_zero = -10, rs_zero2 = 1, not = 6;
        System.out.println(num1+" = ["+Integer.toBinaryString(num1) + "] AND_OP " +num2+" = ["+ Integer.toBinaryString(num2) + "] == " + AND_OP(num1, num2) +" = ["+ Integer.toBinaryString(AND_OP(num1, num2))+"]");
        System.out.println(num1+" = ["+Integer.toBinaryString(num1) + "] OR_OP " +num2+" = ["+ Integer.toBinaryString(num2) + "] == " + OR_OP(num1, num2) +" = ["+ Integer.toBinaryString(OR_OP(num1, num2))+"]");
        System.out.println(num1+" = ["+Integer.toBinaryString(num1) + "] XOR_OP " +num2+" = ["+ Integer.toBinaryString(num2) + "] == " + XOR_OP(num1, num2) +" = ["+ Integer.toBinaryString(XOR_OP(num1, num2))+"]");
        System.out.println(not +" = ["+Integer.toBinaryString(not) + "] NOT_OP == " + NOT_OP(not) +" = ["+ Integer.toBinaryString(NOT_OP(not))+"]");
        System.out.println(num1+" = ["+Integer.toBinaryString(num1) + "] LEFT_SHIFT " +num4+" = ["+ Integer.toBinaryString(num4) + "] == " + LEFT_SHIFT(num1, num4) +" = ["+ Integer.toBinaryString(LEFT_SHIFT(num1, num4))+"]");
        System.out.println(num1+" = ["+Integer.toBinaryString(num1) + "] RIGHT_SHIFT " +num4+" = ["+ Integer.toBinaryString(num4) + "] == " + RIGHT_SHIFT(num1, num4) +" = ["+ Integer.toBinaryString(RIGHT_SHIFT(num1, num4))+"]");
        
        System.out.println("\n"+rs_zero+" = ["+Integer.toBinaryString(rs_zero) + "] RS_ZERO_FILL_OP " +(rs_zero2)+" = ["+ Integer.toBinaryString((rs_zero2)) + "] == " + RS_ZERO_FILL_OP(rs_zero, (rs_zero2)) +" = ["+ Integer.toBinaryString(RS_ZERO_FILL_OP(rs_zero, (rs_zero2)))+"]");
        System.out.println("$ rs_zero counted bits: "+Integer.bitCount(rs_zero));
        System.out.println("$ after shift counted bits: "+Integer.bitCount(RS_ZERO_FILL_OP(rs_zero, (rs_zero2))));
        
        
        System.out.println("\nXOR_OP\n ["+Integer.toBinaryString(num1) + "] = "+num1+" \n["+ Integer.toBinaryString(num2) + "] = "+num2+" \n["+ Integer.toBinaryString(XOR_OP(num1, num2))+"] = "+XOR_OP(num1, num2));

        //AND same as && but in binary 0&1 = 0
        //OR same as || but in binary 0|1 = 1
        //XOR 1|0 = 1   1|1 = 0   0|0 = 0  (ftw)
        //LEFT SHIFT << multiplicates by 2 every 1 step so 12 with 1 step becomes 24; by 2 -> 48
        //RIGHT SHIFT >> divides same as LEFT SHIFT
        //RS_ZERO_FILL ?????????
    }
}
