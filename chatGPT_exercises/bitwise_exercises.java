package chatGPT_exercises;

public class bitwise_exercises {

    public static boolean checkPowerofTwo(int num) {
        if ((num & 2) == 0)
            return true;
        return false;
    }
    public static boolean checkPowerOfTwo(int num) {
        return (num & (num - 1)) == 0; // 8 is 1000 and 7 is 0111 = 0000
    }
    public static void main(String[] args) {

       System.out.println(checkPowerofTwo(16)); //bad solution cz checking least significant bit
       System.out.println(checkPowerOfTwo(16)); 

    }
}

// Write a Java program that takes an integer as input and uses bitwise operations to check if the integer is a power of 2.

// Write a Java program that takes an integer as input and uses bitwise operations to find the next largest number that is a power of 2.

// Write a Java program that takes an integer as input and uses bitwise operations to find the number of set bits in the binary representation of the integer.

// Write a Java program that takes an integer as input and uses bitwise operations to find the parity of the integer (i.e. whether the number of set bits in the binary representation is even or odd).

// Write a Java program that takes two integers as input and uses bitwise operations to find the number of common set bits between the binary representations of the integers.

// Write a Java program that takes an integer as input and uses bitwise operations to swap the odd and even bits of the binary representation of the integer.

// Write a Java program that takes an integer as input and uses bitwise operations to find the binary representation of the integer without the leftmost 1 bit.

// Write a Java program that takes two integers as input and uses bitwise operations to find the minimum and maximum of the two integers without using comparison operators.
