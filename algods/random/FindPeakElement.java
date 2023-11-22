/**
 * https://leetcode.com/problems/find-peak-element/description/
 * LeetCode 162
 */
package algods.random;
/**
 * Thoughts:
 * Linear Approach:
 *  - The following problem can be solved linearly by traversing the input and comparing the next element. 
 *  - If the current Element is greater than next element, return the element
 * Optimized Approach(Binary Search):
 *  - Iterate the input as long as left < right
 *          - calculate the mid of the input array.
 *          - if the mid of the element is greater than mid element, then assign right to mid
 *          - else assign left = mid+1
 *      return left 
 */
public class FindPeakElement {
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        if(nums == null)
            throw new IllegalArgumentException("Input cannot be null.");

        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[i+1])
                return nums[i];
        }
        return -1;
    }

    /**
     * 
     * @param nums
     * @return
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int findPeakElementOpt(int[] nums) {
        if(nums == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
