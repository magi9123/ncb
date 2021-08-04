package first3Task;

/**
 * Write a recursive function that takes a number
 * and returns the sum of all the numbers from zero to that number.
 * For example, if I provide 10 as an input it should return
 * the sum of all the numbers from zero to 10. That is 55.
 */
public class Task3 {

    public static void main(String[] args) {
        System.out.println(sumFromOneToN(10));
    }

    public static int sumFromOneToN(int n) {
        if (n < 1) {
            return 0;
        }
        return n + sumFromOneToN(n - 1);
    }
}
