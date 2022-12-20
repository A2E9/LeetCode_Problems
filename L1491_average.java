public class L1491_average {

    public static double average(int[] salaryArr) {
        // find min max
        // sum up average

        int high = 0, low = salaryArr[0];
        int iHigh = 0, iLow = 0;
        int index = 0;
        for (int salary : salaryArr) {
            if (salary > high) {
                high = salary;
                iHigh = index;
            }
            if (salary < low) {
                low = salary;
                iLow = index;
            }
            index++;
        }

        int sum = 0, count = 0;
        for (int i = 0; i < salaryArr.length; i++) {
            if (i == iHigh || i == iLow) {

            } else {
                sum += salaryArr[i];
                count++;
            }
        }
        double average = ((double)sum) / count;
        System.out.println("average: " + average);
        System.out.println("highIndex: " + iHigh);
        System.out.println("lowIndex: " + iLow);
        System.out.println("sum: " + sum);
        return average;
    }

    public static void main(String[] args) {
        int[] arr = { 48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        average(arr);
    }
}
