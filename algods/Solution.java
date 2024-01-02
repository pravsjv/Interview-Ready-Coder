package algods;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 

Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104


 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Solution {
    // Q1. Are the intervals given sorted? No

    public int kLargestElement(int[] arr, int k) {
        if(arr == null || k < 0)
            throw new IllegalArgumentException("Invalid input.");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int val : arr){
            minHeap.add(val);
            if(minHeap.size() > k)
                minHeap.remove();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        Solution obj = new Solution();
        int result = obj.kLargestElement(arr,2);

        System.out.println(result);
    }
}

