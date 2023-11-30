package algods.random;
/**
 * https://leetcode.com/problems/happy-number/
 * LeetCode: 202
 */
import java.util.HashSet;
public class HappyNumber {

    /*
     * Thoughts:
     *  - According to the definition of a happy number, the number cannot be negative and should eventually reach 1.
     *  - To determine if a given number is happy, we need to repeatedly calculate the sum of the squares of its digits until it reaches 1 or enters a loop.
     *  - Implement a method to calculate the sum of squares of digits.
     *  - To check if the number has entered a loop, we can store the calculated sum of squares in a HashSet and check if each new sum of squares already exists in the HashSet. If it does, it indicates a loop, and we return false.
     *  - The above implementation requires an additional loop. To improve performance, we can use Floyd's cycle detection algorithm.
     */

    public boolean isHappy(int n) {

        // Check if the number is negative
        if (n < 0) {
            return false;
        }

        // Initialize a HashSet to store the calculated sum of squares
        var seen = new HashSet<>();

        // Repeatedly calculate the sum of squares until the number reaches 1 or enters a loop
        while (n != 1 && !seen.contains(n)) {
            n = getNextNumber(n);
            seen.add(n);
        }

        // Check if the number has entered a loop
        if (seen.contains(n)) {
            return false;
        }

        // If the number reaches 1, it is a happy number
        return true;
    }

    private int getNextNumber(int n) {

        // Calculate the sum of squares of digits
        int squareSum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            squareSum += digit * digit;
        }

        // Return the sum of squares
        return squareSum;
    }

    public boolean isHappyFloyd(int n) {

        // Initialize two pointers: slow runner and fast runner
        int slowRunner = n;
        int fastRunner = getNextNumber(n);

        // Implement Floyd's cycle detection algorithm
        while (slowRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNextNumber(slowRunner);
            fastRunner = getNextNumber(getNextNumber(fastRunner));
        }

        // If the fast runner reaches 1, the number is happy
        return fastRunner == 1;
    }

    public static void main(String[] args) {

        // Create an instance of the HappyNumber class
        HappyNumber obj = new HappyNumber();

        // Check if 19 is a happy number
        int n = 19;
        System.out.println("Is 19 a happy number? " + obj.isHappy(n) + "  " + obj.isHappyFloyd(n));

        // Check if 2 is a happy number
        n = 2;
        System.out.println("Is 2 a happy number? " + obj.isHappy(n) + "  " + obj.isHappyFloyd(n));
    }
}
