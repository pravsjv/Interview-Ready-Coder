package algods.facebook.mostfrequent;
/**
 * https://leetcode.com/problems/making-a-large-island/description/
 * Leetcode: 827
 */

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class MakingLargeIsland {
    private int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        MakingLargeIsland obj = new MakingLargeIsland();
        
        System.out.println(obj.largestIsland(grid));
    }

    private Map<Integer,Integer> squareSize = new HashMap<>();
    private int gridLen;
    public int largestIsland(int[][] grid) {
        if(grid == null)
            throw new IllegalArgumentException("Input cannot be null.");
        this.gridLen = grid.length;

        int marker = 2; 
        int max = 0; 
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int size = getSize(grid, i, j, marker++);
                    squareSize.put(marker - 1, size); 
                    max = Math.max(max, size); 
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    int curr = 1; 
                    HashSet<Integer> visited = new HashSet<>(); 
                    for(int[] dir: directions) {
                        int newrow = i + dir[0], newcol = j + dir[1];
                        if(withinRange(newrow, newcol) && grid[newrow][newcol] != 0 && !visited.contains(grid[newrow][newcol])) {
                            visited.add(grid[newrow][newcol]);
                            curr += squareSize.get(grid[newrow][newcol]);
                        }
                    }
                    max = Math.max(curr, max);
                }
            }
        }
        return max; 
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(N^2)

    private int getSize(int[][] grid, int row, int col, int marker) {
        if(!withinRange(row,col))
            return 0;

        if(grid[row][col] != 1)
            return 0;

        grid[row][col] = marker;
        int result = 1;
        for(int[] direction : directions) {
            int nrow = direction[0]+row;
            int ncol = direction[1]+col;

            if(withinRange(nrow,ncol) && grid[nrow][ncol] == 1 && grid[nrow][ncol]!= marker){
                result += getSize(grid, nrow, ncol, marker);
            }
        }
        return result;
    }

    private boolean withinRange(int row, int col) {
        return (row>=0 && row<gridLen && col>=0 && col<gridLen);
    }

}
