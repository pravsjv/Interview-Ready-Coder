package algods.random;
/**
 * LeetCode 1814
 */

/**
* Thoughts: 
* Simplify the Equation: Transform the given equation nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) into nums[i] - rev(nums[i]) = nums[j] - rev(nums[j]).
* Focus on Differences: Instead of directly comparing nums[i] and nums[j], focus on the difference between each number and its reverse. This simplifies the problem and reduces the number of pairs to consider.
* Utilize a Map: Employ a HashMap to store the frequency of each difference between a number and its reverse. This allows for efficient lookups and simplifies the counting process.
* Increment Count: As you iterate through the array, calculate the difference for each number and check if it exists in the HashMap. If it does, increment the corresponding count.
* Return Total Count: After processing all the numbers, return the total count of unique differences observed. This represents the number of nice pairs in the array. 
*/
import java.util.HashMap;
public class CountNicePairs {

    private static final int MOD = 1000000007;

    /**
     * Counts the number of nice pairs in an array of non-negative integers.
     *
     * @param nums The array of non-negative integers
     * @return The number of nice pairs in the array
     */
    public int countNicePairs(int[] nums) {
        if (nums == null) {
            return 0;
        }

        // Create an array to store the differences between each number and its reverse
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - reverse(nums[i]);
        }

        // Create a HashMap to store the frequency of each difference
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        // Iterate through the array and count the occurrences of each difference
        for (int val : arr) {
            result = (result + map.getOrDefault(val, 0)) % MOD;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // Return the total count of nice pairs
        return result;
    }

    /**
     * Calculates the reverse of a non-negative integer.
     *
     * @param val The non-negative integer to reverse
     * @return The reverse of the integer
     */
    private int reverse(int val) {
        int result = 0;
        while (val != 0) {
            result = result * 10 + val % 10;
            val /= 10;
        }
        return result;
    }
}

// Time Complexity: O(N) : O(N) for the first iteration to store the differences and 
// then O(N) for iterating to find and store the same values.
// Space Complexity: O(N) for storing the differences
/*
 * Follow up questions:
 * Q1. The above solution doesn't work for negative numbers. How would you modify the solution to handle negative integers?
 * A. Modify the code to find the difference as arr[i] = Math.abs(nums[i] - reverse(nums[i]));
 * 
 * Q2. How would we optimize if its a large array
 * A. we can do many optimization and some of them include:
 *  - employ an efficient data structre like min-sketch or bloom filter to find the frequencies of differences
 *  - Parallel Processing
 *  - implementing the range partitioning
 * 
 * Q3. How would you handle duplicates pairs of indicies?
 * A. Introduce preprocessing of the arrays by sorting the elements and identify the duplicate pairs and removing them.
 */
