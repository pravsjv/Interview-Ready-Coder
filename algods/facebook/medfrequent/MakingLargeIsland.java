package algods.facebook.medfrequent;
/*
 * https://leetcode.com/problems/making-a-large-island/
 * Leetcode: 827
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class MakingLargeIsland {
    private int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public int largestIsland(int[][] grid) {
        int gridLen = grid.length;
        UnionFind uf = new UnionFind();
        int currId = 2;

        for(int r=0; r<gridLen; r++){
            for(int c=0; c<gridLen; c++) {
                if(grid[r][c] == 1){
                    uf.add(currId);
                    dfs(grid, r, c, currId++, gridLen);
                }
            }
        }

        int maxSize = 0;
        for(int r=0; r<gridLen; r++) {
            for(int c=0; c<gridLen; c++) {
                if(grid[r][c] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    for(int[] direction : directions){
                        int nr = r+direction[0];
                        int nc = c+direction[1];
                        if(nr >=0 && nr<gridLen && nc >=0 && nc<gridLen && grid[nr][nc] == 1)
                            neighbors.add(uf.find(grid[nr][nc]));
                    }
                    int currSize = 1;
                    for(int neighbor : neighbors){
                        currSize += uf.getSize(neighbor);
                    }
                    maxSize = Math.max(maxSize,currSize);
                }
            }
        }

        return maxSize;
    }

    private void dfs(int[][] grid, int r, int c, int currId, int gridLen) {
        if(r<0 || r>=0 || c <0 || c>=0 || grid[r][c] != 1)
            return;

        grid[r][c] = currId;
        for(int[] direction : directions) {
            dfs(grid, r+direction[0], c+direction[1], currId, gridLen);
        }
    }

    private class UnionFind {
        private Map<Integer,Integer> parent;
        private Map<Integer,Integer> size;

        public UnionFind(){
            parent = new HashMap<>();
            size  = new HashMap<>();
        }

        public void add(int x){
            parent.put(x,x);
            size.put(x,1);
        }

        public int find(int x){
            if(parent.get(x) != x){
                parent.put(x,parent.get(x));
            }
            return parent.get(x);
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
                parent.put(rootX,rootY);
                size.put(rootY,size.get(rootX)+size.get(rootY));
            }
        }

        public int getSize(int x) {
            return size.get(find(x));
        }
    }
}
