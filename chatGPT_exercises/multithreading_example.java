package chatGPT_exercises;

public class multithreading_example {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int numberOfThreads = 4;
        int chunkSize = numbers.length / numberOfThreads; // size for a thread to compute

        ArraySumThread[] threads = new ArraySumThread[numberOfThreads];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * chunkSize;    // 0*2|0  1*2|2  2*2|8    
            int endIndex = (i + 1) * chunkSize;// 1*2|2  2*2|8  (3*2|12)->10 

            System.out.println("startIndex: "+startIndex);
            System.out.println("endIndex: "+endIndex);
            System.out.println("chunkSize: "+chunkSize);
            System.out.println("numbers.length: "+numbers.length);

            if (i == numberOfThreads - 1) // 3 if last thread, should compute left numbers
                endIndex = numbers.length; // 10

            threads[i] = new ArraySumThread(numbers, startIndex, endIndex); // initialize 
            threads[i].start(); // run() add all numbers[] in chunkSizes -> 4
        }

        long sum = 0;
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join(); // waiting for all threads to complete to sum them up
            } catch (Exception e) {
                e.printStackTrace();
            }
            sum += threads[i].getSum(); // get from all threads sums and add together
        }
        System.out.println("Sum of arr elements: " + sum);
    }
}

class ArraySumThread extends Thread {
    int[] numbers;
    int startIndex;
    int endIndex;
    long sum;

    public ArraySumThread(int[] numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sum += numbers[i];
        }
    }

    public long getSum() {

        return sum;
    }

}
