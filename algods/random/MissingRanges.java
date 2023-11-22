/**
 * https://leetcode.com/problems/missing-ranges/
 * LeetCode 163
 */
package algods.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/*
 * Thoughts:
 * Read the question properly and understand the requirements of the question.
 * Identify all the cases where elements can be missed like 
 *      if input length is zero,
 *          create the result with lower and upper values and return the result.
 *      missing elements from lower to first element(if first element is greater than lower)
 *      missing elements inside the input boundaries
 *              - iterate till last but one element
 *                  - check if the next element and current element difference is less than or equal to 1
 *                      - add the elements between currentElement+1 and nextElement-1 as lower and upper boundaries respectively
 *      missing elements from last element to the upper limit(if last element is less than upper limit)
 *      return the result
 */
public class MissingRanges {
    /*
     * Time Complexity: O(N)
     * Space Complecity: O(1)
     */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        
        // case1: if len of the input is null
        if(nums.length == 0){
            result.add(Arrays.asList(lower,upper));
            return result;
        }

        // case2: add the elements between lower and  first element
        if(lower < nums[0])
            result.add(Arrays.asList(lower,nums[0]-1));

        // case3: missing elements inside the boundaries of nums array
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i] > 1){
                result.add(Arrays.asList(nums[i]+1,nums[i+1]-1));
            }
        }

        // case4: add elements to the result that are missing if last element is less than upper
        if(upper > nums[len-1])
            result.add(Arrays.asList(nums[len-1]+1,upper));

        return result;
    }
}
