package algods.random;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class provides a method to find the k closest elements to a given target value in an array.
 *
 * @author Praveen Kumar JV
 */
public class ArithmeticSubarrays {
    /**
     * Determines whether each subarray defined by the given ranges is an arithmetic sequence.
     *
     * @param nums The input array of integers.
     * @param l An array of starting indices for the subarrays.
     * @param r An array of ending indices for the subarrays.
     * @return A list of boolean values indicating whether each subarray is an arithmetic sequence.
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        if (nums == null || l.length != r.length) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        List<Boolean> result = new ArrayList<>(); // A list to store the results for each subarray
        for (int i = 0; i < l.length; i++) {
            // Create a subarray from the given range
            int[] subarray = new int[r[i] - l[i] + 1];
            for (int j = 0; j < subarray.length; j++) {
                subarray[j] = nums[l[i] + j];
            }

            // Check if the subarray is an arithmetic sequence
            boolean isArithmetic = check(subarray);
            result.add(isArithmetic);
        }

        return result; // Return the list of results
    }

    /**
     * Checks whether the given array is an arithmetic sequence.
     *
     * @param arr The array to check for arithmetic sequence.
     * @return True if the array is an arithmetic sequence, false otherwise.
     */
    private boolean check(int[] arr) {
        // Sort the array to determine the common difference
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        // Check if all elements follow the common difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true; // If all elements follow the common difference, it's an arithmetic sequence
    }

    /**
     * Optimizes the check for arithmetic sequence using a hash set and range calculations.
     *
     * @param arr The array to check for arithmetic sequence.
     * @return True if the array is an arithmetic sequence, false otherwise.
     */
    private boolean checkOpt(int[] arr) {
        int len = arr.length; // Length of the array
        HashSet<Integer> set = new HashSet<>(); // A hash set to store unique elements in the array
        int minVal = Integer.MAX_VALUE; // Initialize minimum value
        int maxVal = Integer.MIN_VALUE; // Initialize maximum value

        // Find the minimum and maximum values, and add all elements to the hash set
        for (int val : arr) {
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
            set.add(val);
        }

        // Check if the range of values is consistent with an arithmetic sequence
        if ((maxVal - minVal) % (len - 1) != 0) {
            return false;
        }

        int diff = (maxVal - minVal) / (len - 1); // Calculate the common difference
        int curr = minVal + diff; // Initialize the expected value of the next element

        // Check if all elements follow the expected values
        while (curr < maxVal) {
            if (!set.contains(curr)) {
                return false;
            }
            curr += diff;
        }

        return true; // If all elements follow the expected values, it's an arithmetic sequence
    }
}

