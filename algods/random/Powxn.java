package algods.random;
/**
 * leetcode: 50
 */

/**
 * Thoughts:
 * - The power of a number x raised to an integer n can be expressed as a
 * product of x multiplied by itself n times.
 * For instance, x^4 can be written as x * x * x * x.
 * This approach allows us to calculate x^n in O(N) time complexity, where N is
 * the value of n.
 * - Alternatively, we can use binary exponentiation to calculate x^n more
 * efficiently.
 * This method involves repeatedly squaring the base x and dividing the exponent
 * n by 2.
 * For example, to calculate x^4 using binary exponentiation, we would first
 * square x to get x^2, then square x^2 to get x^4.
 * This approach reduces the time complexity to O(log n), where log n is the
 * logarithm of n.
 * - Before implementing the power function, we need to consider a few edge
 * cases:
 * - If n is 0, then the result is x^0 = 1, regardless of the value of x.
 * - If n is negative, then the result is 1/x^n. This is because x^n is
 * undefined for negative values of n, but we can still define 1/x^n for
 * negative n.
 * - If n is odd, then the result is x * x^(n-1)/2. This is because x^n can be
 * expressed as x * x^(n-1) when n is odd.
 * By taking these edge cases into account, we can implement a robust and
 * efficient power function that works correctly for all valid input values
 */

public class Powxn {
    /**
     * Calculates the power of a number x raised to an integer n.
     *
     * @param x The base number
     * @param n The exponent
     * @return The result of x raised to the power of n
     *
     *         Time complexity: O(n) for iterative approach
     *         O(log n) for binary exponentiation approach
     *
     *         Space complexity: O(1) for both iterative and binary exponentiation
     *         approaches
     */
    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / power(x, -n);
        }

        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public double myPow(double x, int n) {
        return powerBinaryExponentiation(x, (long) n);
    }

    /**
     * Calculates the power of a number x raised to an integer n using binary exponentiation.
     *
     * @param x The base number
     * @param n The exponent
     * @return The result of x raised to the power of n
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    public double powerBinaryExponentiation(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / powerBinaryExponentiation(x, -n);
        }

        if (n % 2 == 1) {
            return x * powerBinaryExponentiation(x, n - 1);
        } else {
            return powerBinaryExponentiation(x * x, n / 2);
        }
    }
}
