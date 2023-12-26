package algods.facebook.medfrequent;
/**
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 * LeetCode: 523
 */
import java.util.HashMap;
public class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k == 0)
            return false;
        
        int sum = 0;
        var map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            sum %= k;

            if(map.get(sum) != null &&  i-map.get(sum)>1){
                return true;
            } else {
                map.put(sum,i);
            }
        }
        return false;
    }
}
