package algods.facebook.medfrequent;
/*
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * LeetCode: 633
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for(long a=0; a*a<=c; a++) {
            int b = c - (int)(a*a);
            if(binarySearch(0,b,b))
                return true;
        }
        return false;
    }

    private boolean binarySearch(long start, long end, long target){
        if(start > end)
            return false;

        long mid = start+(end-start)/2;
        if(mid*mid == target)
            return true;

        if(mid*mid > target)
            return binarySearch(start, mid-1, target);

        return binarySearch(mid+1, end, target);
    }

    public static void main(String[] args){
        SumOfSquareNumbers obj = new SumOfSquareNumbers();
        System.out.println(obj.judgeSquareSum(5));
        System.out.println(obj.judgeSquareSum(11));
    }
}
