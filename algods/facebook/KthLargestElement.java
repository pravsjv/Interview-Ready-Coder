package algods.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
public class KthLargestElement {
    public int bruteForce(int[] arr, int k) {
        if(arr == null)
            throw new IllegalArgumentException("Input cannot be null.");

        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)

    public int countSortSol(int[] arr, int k){
        if(arr == null)
            throw new IllegalArgumentException("Input array cannot be null.");

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int val : arr){
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal,val);
        }

        int[] count = new int[maxVal-minVal+1];
        for(int val: arr){
            count[val-minVal]++;
        }

        int remain = k;
        for(int i=count.length-1; i>=0; i--){
            remain -= count[i];
            if(remain<=0)
                return i+minVal;
        }
        return -1;
    }
    // Time Complexity: O(N+M)
    // Space Complexity: O(M)

    public int heapSol(int[] arr, int k){
        if(arr == null)
            throw new IllegalArgumentException("Input cannot be null.");

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int val : arr){
            heap.add(val);
            if(heap.size()>k){
                heap.remove();
            }
        }
        return heap.peek();
    }
    // Time Complexity: O(NlogK)
    // Space Complexity: O(k)


    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        KthLargestElement obj = new KthLargestElement();
        System.out.println("Kth largest Element using brute force: "+obj.bruteForce(arr, 2));

        System.out.println("Kth largest Element using count sort: "+obj.countSortSol(arr, 2));

        System.out.println("Kth largest Element using Heap Solution: "+obj.countSortSol(arr, 2));
    }
}
