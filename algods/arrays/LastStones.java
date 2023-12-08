/**
 * Last Stone Weight
 * LeetCode 1046
 */
package algods.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Thoughts:
 *  - Decoding the question:
 *      - Chose the heaviest stones in each turn : so to the heaviest stones every turn, the arrays should be sorted or added in a priority queue.
 *      - If both the stones are same destroyed, else stone of weight y has new weight y-x
 *        - while iterating the heap, if the top 2 stones are not equal, then take the difference and add it to the heap.
 *      - return the heap value if the heap size is not zero.
 * 
 * Additional Notes:
 *  - Priority queue significantly improves the performance than the sorting solution as the solution requires O(N^2) TC
 */
public class LastStones {
    public int lastStoneWeight(int[] stones) {
        if(stones == null)
            throw new IllegalArgumentException("Input cannot be null.");

        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int stone : stones){
            heap.offer(stone);
        }

        while(heap.size()>1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();

            if(stone1 != stone2){
                heap.offer(stone1-stone2);
            }
        }
        return heap.isEmpty()?0:heap.remove();
    }

    // Time Complexity: O(nlogn) priority queue takes logN for adding and remove elements
    //  and adding the values to heap takes O(N) 
    // Space Complexity: O(N)

    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1};
        LastStones ls = new LastStones();
        System.out.println(ls.lastStoneWeight(stones));
        System.out.print(ls.lastStoneWeight(new int[]{3,3,3,3,3}));
    }
}