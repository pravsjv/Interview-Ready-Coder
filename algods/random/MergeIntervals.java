package algods.random;

/**
 * LeetCode 56
 */

 /**
  * Thoughts:
  *   To merge overlapping intervals, ensure that the intervals are sorted in ascending order based on their starting values. 
  *   Then, iterate through the sorted intervals. For each interval, check if it overlaps with the next interval. 
  *   If it does, determine the maximum ending value between the two intervals and update the ending value of the current interval. 
  *   If there is no overlap or if the current interval ends before the next interval starts, add the current interval as a separate entry. 
  *   This process effectively merges overlapping intervals while preserving non-overlapping intervals.
  */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class provides a method to merge overlapping intervals in an array of integer intervals.
 * An interval is represented by a pair of integers (start, end), where start is the starting
 * value of the interval and end is the ending value of the interval.
 */
public class MergeIntervals {

    /**
     * Merges overlapping intervals in an array of integer intervals.
     *
     * @param intervals The array of integer intervals to merge
     * @return The merged intervals
     *
     * Time complexity: O(n log n) as it requires sorting
     * Space complexity: O(n)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // Sort the intervals based on their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Create a linked list to store the merged intervals
        var merged = new LinkedList<int[]>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] > interval[0]) {
                // If the current interval overlaps with the last merged interval, merge them
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            } else {
                // If the current interval does not overlap with the last merged interval, add it as a new interval
                merged.add(interval);
            }
        }

        // Convert the linked list of intervals to an array
        return merged.toArray(new int[merged.size()][]);
    }
}
