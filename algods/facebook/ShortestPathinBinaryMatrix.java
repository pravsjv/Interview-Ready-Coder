package algods.facebook;
/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 * LeetCode: 1091
 */
/*
 * Decoding the question:
 *  Given n*n binary matrix
 *  All the visited cells are marked as 0
 *  all adjacent cells are connected in 8 directions
 *  return shortest clear path if possible, else return -1
 *  Clear Path is a path that starts from top left (0,0) to bottom right cell (n-1,n-1)
 */
import java.util.Queue;
import java.util.LinkedList;
public class ShortestPathinBinaryMatrix {
    private int[][] directions = {{-1,0},{0,-1},{0,1},{1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null)
            throw new IllegalArgumentException("Input cannot be null.");
        int len = grid.length;
        if(grid[0][0]== 1 || grid[len-1][len-1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;

        int shortestPath = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                if(cell[0]==len-1 && cell[1]==len-1)
                    return shortestPath;

                for(int[] direction : directions){
                    int row = cell[0]+direction[0];
                    int col = cell[1]+direction[1];

                    if(row>=0 && col>=0 && row<len && col<len && grid[row][col]==0){
                        q.offer(new int[]{row,col});
                        grid[row][col] = 1;
                    }
                }
            }
            ++shortestPath;
        }
        return shortestPath;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestPathinBinaryMatrix obj = new ShortestPathinBinaryMatrix();
        System.out.println("Shortest Path in the given binary matrix is: "+obj.shortestPathBinaryMatrix(grid));
    }
}
