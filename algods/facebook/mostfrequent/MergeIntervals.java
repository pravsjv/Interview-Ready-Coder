package algods.facebook.mostfrequent;

import java.util.Arrays;
import java.util.LinkedList;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null)
            throw new IllegalArgumentException("Input cannot be null.");

        // Sort the intervals(required only if the description doesn't mention its a sorted input)
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // Time Complexity: O(NlogN) sorting the intervals take NLogN time complecity.
    // Space Complexity: O(N) in the worst case linked list would contain all the intervals if there is no overlap.

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        int[][] result = obj.merge(intervals);

        for(int[] interval : result)
            System.out.println(interval[0]+"  "+interval[1]);
        // Output Expected : [[1,6],[8,10],[15,18]]
    }
}
