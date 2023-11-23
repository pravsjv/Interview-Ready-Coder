package algods.random;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a method to find the k closest elements to a given target value in an array.
 *
 * @author Praveen Kumar JV
 */
public class FindKClosestelements {

    /**
     * Finds the k closest elements to the given target value in the specified array.
     *
     * @param arr The input array of integers.
     * @param k The number of closest elements to find.
     * @param x The target value to compare the elements against.
     * @return A list of the k closest elements to the target value.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }

        // Check if the entire array is small enough to be the k closest elements
        if (arr.length == k) {
            List<Integer> result = new ArrayList<>(k);
            for (int val : arr) {
                result.add(val);
            }
            return result;
        }

        // Initialize two pointers, 'left' and 'right', to the beginning and end of the array
        int left = 0;
        int right = arr.length - 1;

        // Use binary search to find the index of the first element that is greater than or equal to the target value
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Adjust the indices to represent the range of k closest elements
        left = left - 1;
        right = left + 1;

        // Iterate until the desired number of closest elements (k) are found
        while (right - left - 1 < k) {
            // Handle the case where the left pointer reaches the beginning of the array
            if (left == -1) {
                right++;
                continue;
            }

            // Compare the absolute differences between the target value and the elements at the left and right pointers
            if (right == arr.length || Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)) {
                left--;
            } else {
                right++;
            }
        }

        // Extract the k closest elements from the adjusted range
        List<Integer> result = new ArrayList<>(k);
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result; // Return the list of k closest elements
    }
}
