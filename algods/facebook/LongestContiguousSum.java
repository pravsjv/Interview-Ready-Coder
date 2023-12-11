package algods.facebook;
/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * Leetcode: 674
 */
public class LongestContiguousSum {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int left = 0;
        int result = 0;
        for(int right=1; right<nums.length; right++){
            if(nums[right]<=nums[right-1])
                left = right;
            result = Math.max(result,right-left+1);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,4,7};

        LongestContiguousSum obj = new LongestContiguousSum();
        System.out.println("Longest subsquence in a given array: "+obj.findLengthOfLCIS(arr));
    }
}
