package algods.facebook;
/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * LeetCode 42
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxCollectedWater = 0;

        int left =0, right=height.length-1;
        int leftMax=0, rightMax=0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left]>=leftMax)
                    leftMax=height[left];
                else
                    maxCollectedWater+=(leftMax-height[left]);
                ++left;
            } else {
                if(rightMax<=height[right])
                    rightMax=height[right];
                else
                    maxCollectedWater+=rightMax-height[right];
                --right;
            }
        }
        return maxCollectedWater;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater obj = new TrappingRainWater();

        System.out.println("Total rain water trapped: "+obj.trap(arr));
    }
}
