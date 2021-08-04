package first3Task;

import java.util.Arrays;

/**
 * Write Java program to find smallest and largest element in an array of integers.
 */
public class Task2 {

    public static void main(String[] args) {

        int[] numbers = new int[]{4, 20, -1, 15, 3};

        Arrays.sort(numbers);
        System.out.println("Smallest element is: " + numbers[0] + System.lineSeparator()
                + "Biggest element is: " + numbers[numbers.length - 1]);
    }

}
