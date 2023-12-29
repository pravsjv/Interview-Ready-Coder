package algods.facebook.mostfrequent;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
 * Leetcode: 317
 */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancefromBuildings {
    private int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    private int rowLen;
    private int colLen;
    private int[][] grid;
    private int houses;

    public int shortestDistance(int[][] grid) {
        if (grid == null)
            throw new IllegalArgumentException("Input cannot be null.");

        this.rowLen = grid.length;
        this.colLen = grid[0].length;
        this.grid = grid;

        int[][] distances = new int[rowLen][colLen];
        int[][] reachCount = new int[rowLen][colLen];
        houses = 0;

        for(int i=0; i<rowLen; i++){
            for(int j=0; j<colLen; j++){
                if(grid[i][j] == 1){
                    houses++;
                    bfs(i,j,distances,reachCount);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                if(grid[i][j] == 0 && distances[i][j] == houses)
                    minDistance = Math.min(minDistance,distances[i][j]);
            }
        }

        return minDistance==Integer.MAX_VALUE?-1:minDistance;
    }

    private void bfs(int row, int col, int[][] distances, int[][] reachCount) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});

        boolean[][] seen = new boolean[rowLen][colLen];
        seen[row][col] = true;

        int steps = 0;

        while(!q.isEmpty()) {
            steps++;
            for(int level=q.size(); level>0; level--){
                int[] curr = q.poll();
                for(int[] direction : directions) {
                    int nr = direction[0]+curr[0];
                    int nc = direction[1]+curr[1];

                    if(withinRange(nr, nc) && !seen[nr][nc] && grid[nr][nc] == 0){
                        seen[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                        distances[nr][nc] += steps;
                        reachCount[nr][nc]++;
                        if(reachCount[nr][nc] == houses)
                            return;
                    }
                }
            }
        }

    }

    private boolean withinRange(int row, int col) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }
}
