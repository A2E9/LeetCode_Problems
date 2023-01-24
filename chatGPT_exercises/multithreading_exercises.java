package chatGPT_exercises;

// Write a program that creates two threads. The first thread should print the 
//numbers from 1 to 10, while the second thread should print the numbers from 11
//to 20. Make sure that the output is in order, i.e., the numbers are printed in ascending order.
class AscendNumbers extends Thread {
    int start;
    int end;
    int number;

    public AscendNumbers(int number, int start, int end) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public void run() {
        if (start < end || end > number) {
            System.err.println("INDEX_OUT_OF_BOUNDS");
        } else
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
    }
}

// Write a program that creates two threads. The first thread should print the
// characters of a string in reverse order,
// while the second thread should print the characters of the same string in the
// original order. Make sure that the output is in order, i.e., the characters
// are printed in the correct order.
class StringReverse extends Thread {

    String str;
    char[] charArr;
    static boolean reverse = true;

    public StringReverse(String str) {
        this.str = str;
        charArr = str.toCharArray();
    }

    @Override
    public void run() {
        if (reverse) {
            for (int i = charArr.length - 1; i >= 0; i--)
                System.out.print(charArr[i]);
        } else {
            System.out.println();
            for (int i = 0; i < charArr.length; i++)
                System.out.print(charArr[i]);
        }
        reverse = !reverse;
    }
}

// Write a program that creates two threads. The first thread should calculate
// the factorial of a number, while the
// second thread should calculate the fibonacci series of a number. Make sure
// that the output is in order, i.e., the factorial and fibonacci series are
// calculated and printed in the correct order.
class Fibonacci_Factorial extends Thread {
    int number;
    static boolean fib_fac = false;

    public Fibonacci_Factorial(int num) {
        this.number = num;
    }

    @Override
    public void run() {
        if (fib_fac)
            fibonacci();
        else
         factorial();
        fib_fac = !fib_fac;
        System.out.println();
    }

    public void fibonacci() {
        int maxNumber = number, previousNumber = 0, nextNumber = 1;

        int i=1;
        while(i <= maxNumber)
        {
            System.out.print(previousNumber+" ");
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
            i++;
        }
    }

    public void factorial() {
        int res=1;
        for (int i = 1; i <= number; i++) {
            System.out.print((res*=i) +" ");
        }
    }

}

// Write a program that creates two threads. The first thread should read a file
// and count the number of occurrences of
// a specific word, while the second thread should print the number of
// occurrences of that word. Make sure that the output is in order, i.e., the
// word is counted and printed in the correct order.

// Write a program that creates two threads. The first thread should generate a
// random number, while the second thread
// should check if the number is prime. Make sure that the output is in order,
// i.e., the number is generated and checked for primality in the correct order.

// Write a program that creates three threads. The first thread should sort an
// array of integers in ascending order, the
// second thread should sort the same array in descending order, and the third
// thread should print the sorted array. Make sure that the output is in order,
// i.e., the array is sorted and printed in the correct order.

// Write a program that creates three threads. The first thread should find the
// minimum value in an array of integers,
// the second thread should find the maximum value in the same array, and the
// third thread should print the minimum and maximum values. Make sure that the
// output is in order, i.e., the minimum and maximum values are found and
// printed in the correct order.

// Write a program that creates two threads. The first thread should calculate
// the average of an array of integers,
// while the second thread should print the average. Make sure that the output
// is in order, i.e., the average is calculated and printed in the correct
// order.

// Write a program that creates two threads. The first thread should calculate
// the standard deviation of an array of
// integers, while the second thread should print the standard deviation. Make
// sure that the output is in order, i.e., the standard deviation is calculated
// and printed in the correct order.

// Write a program that creates three threads. The first thread should calculate
// the dot product of two arrays of
// integers, the second thread should calculate the cross product of the same
// arrays, and the third thread should print the dot and cross product. Make
// sure that the
public class multithreading_exercises {

    public static void f_ascendNums() {
        int numbers = 20;
        int numOfThreads = 2;
        int chunkSize = numbers / 2;
        AscendNumbers[] threads = new AscendNumbers[numOfThreads];
        if (numOfThreads < chunkSize)
            for (int i = 0; i < threads.length; i++) {
                int startIndex = i * chunkSize + 1;
                int endIndex = (i + 1) * chunkSize;

                threads[i] = new AscendNumbers(numbers, startIndex, endIndex);
                threads[i].start();

                try {
                    threads[i].join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        else
            System.err.println("NUMBER_OFTHREADS_BIGGER_THAN_NUMBERS");
    }

    public static void s_stringRev() throws InterruptedException {
        String str = "characters";
        int threadsAmount = 2;
        StringReverse[] threads = new StringReverse[threadsAmount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new StringReverse(str);
            threads[i].start();
            threads[i].join();
        }
    }

    public static void t_fib_fac()throws InterruptedException {
        Fibonacci_Factorial ff = new Fibonacci_Factorial(5);
        ff.start();
        ff.join();
        Fibonacci_Factorial ff1 = new Fibonacci_Factorial(5);
        ff1.start();
        ff1.join();
    }
    public static void main(String[] args) throws InterruptedException {

    }

    
}
