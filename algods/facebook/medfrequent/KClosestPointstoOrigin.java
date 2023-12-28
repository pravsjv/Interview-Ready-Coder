package algods.facebook.medfrequent;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || k< 0)
            throw new IllegalArgumentException("Input cannot be null.");

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points) {
            maxHeap.offer(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        int[][] closestPoints = new int[k][2];
        while(k>0){
            closestPoints[--k] = maxHeap.poll();
        }

        return closestPoints;
    }
    // Time Complexity: O(NlogK) where loop takes O(N) and inside operations to maintain the order takes O(logK) tc.
    // Space Complexity: O(K) as priority Queue stores K elements at any given time.

    public static void main(String[] args) {
        KClosestPointstoOrigin obj = new KClosestPointstoOrigin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int[][] result = obj.kClosest(points, 2);

        for(int[] point : result){
            System.out.println(point[0]+"  "+point[1]);
        }
    }
}
