package algods.facebook.medfrequent;
/*
 * https://leetcode.com/problems/powx-n/description/
 * LeetCode: 50
 */
public class pow {
    public double myPow(double x, int n) {
        return binaryPOW(x,(long)n);
    }
    private double binaryPOW(double x, long n) {
        if(n == 0)
            return 1;
        
        if(n < 0){
            return 1/binaryPOW(x, -n);
        }

        if(n%2 == 0){
            return binaryPOW(x*x, n/2);
        }

        return x*binaryPOW(x*x, (n-1)/2);
    }

    // Time Complexity: O(log N)
    // Space Complexity: O(log N) due to recursive calls

    public static void main(String[] args) {
        pow obj = new pow();
        System.out.println(obj.binaryPOW(2.000, 10));
    }
}
