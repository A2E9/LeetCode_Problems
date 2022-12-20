public class L1281_subtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        
        String num = Integer.toString(n);
        int numLength = num.length();
        int sum = 0, mult = 1;
        for (int i = 0; i <  numLength; i++) {
            sum += Character.getNumericValue(num.charAt(i));
            mult *= Character.getNumericValue(num.charAt(i));
        }
        try {
            Thread.sleep(101);
        } catch (Exception e) {
        }
        return mult-sum;
    }
    
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234)); 
    }
    }
    
    