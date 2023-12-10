package algods.facebook;
/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * LeetCode 1011
 */
public class ShippingCapacity {
    public int shipWithinDays(int[] weights, int days) {
        if(weights==null || days<=0)
            throw new IllegalArgumentException("Input cannot be null.");

        int maxWeight=0, totalWeight=0;
        for(int weight : weights){
            maxWeight = maxWeight<weight?weight:maxWeight;
            totalWeight += weight;
        }

        int left = maxWeight;
        int right = totalWeight;
        while(left < right){
            int mid = (left+right)/2;
            if(isFeasible(weights,mid,days))
                right = mid;
            else 
                left = mid+1;
        }
        return left;
    }

    private boolean isFeasible(int[] weights, int c, int days){
        int currLoad=0, daysNeeded=1;
        for(int weight : weights){
            currLoad += weight;
            if(currLoad > c){
                daysNeeded++;
                currLoad = weight;
            }
        }
        return daysNeeded <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        ShippingCapacity obj = new ShippingCapacity();
        System.out.print(obj.shipWithinDays(weights, 5)+" is the Minimum weight required to ship all packages within "+days+" days");
    }
}
