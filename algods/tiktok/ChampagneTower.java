/**
 * Champagne Tower
 * LeetCode: 799
 */

package algods.tiktok;
/**
 * thoughts:
 *  - simulate how the champagne is poured and once the first glass is filled, poured is substracted by 1
 *    and then the excess is divided by 2 => X-1/2
 *  - 
 *  - Here to optimize, we do not need the whole tower size but only till the size of the query_row
 *  - 
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured<0 || query_row<0)
            throw new IllegalArgumentException("input cannot be null.");

        var tower = new Double[query_row+1][query_row+1];
        tower[0][0] = (double)poured;
        for(int row=0; row<query_row; ++row){
            for(int col=0; col<row; ++col) {
                double excess = (double)(tower[row][col]-1)/2.0;

                if(excess > 0){
                    tower[row+1][col] += excess;
                    tower[row+1][col+1] += excess;
                }
            }
        }

        return 1>tower[query_row][query_glass]?tower[query_row][query_glass]:1;
    }
}
// Time Complexity : O(R^2) or O(1) as the query_row is constant
// Space Complexity: O(R^2) or O(1) - same reason as above
