/**
 * The Maze
 * LeetCode: 490
 */
package algods.random;

import java.util.Queue;
import java.util.LinkedList;
/*
 * Thoughts:
 *  - As from the problem statement, it requires us to traverse the maze from start to destination.
 *  - while traversal, we need to check if there is an obstacle, else try finding a way. If there is a path, return true, else false.
 *  - This can be solved by both DFS and BFS.
 *  - BFS Approach: Idea is to traverse the graph for each cell in all 4 directions
 *      - initiate a static final variable directions that has the directions for all the 4 sides
 *      - For BFS traversal, initialize the queue with start values and to as we cannot edit the maze matrix, create a boolean matrix to mark the visited cells.
 *      - traverse the queue while its not empty
 *          - extract the element from the queue
 *          - check if the element polled from queue is equal to destination, then return true
 *          - else iterate over the four directions as long there is row and column are inside the boundaries and current cell value is not an obstacle
 *          - post the 4 directions iterations, revert the cell to the initial value
 *          - check if the cell is visited already, else add the current row and val to the queue and mark it as visited.
 *      
 */
public class Maze {
    private static final int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null)
            throw new IllegalArgumentException("input cannot be null");

        int rowLen = maze.length;
        int colLen = maze[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();

        // adding the start cell to the queue
        q.offer(new Pair<>(start[0],start[1]));
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            Pair<Integer,Integer> currCell = q.poll();

            if(currCell.getKey() == destination[0] && currCell.getValue() == destination[1])
                return true;

            for(int[] direction : directions) {
                int currRow = currCell.getKey();
                int currCol = currCell.getValue();

                while(currRow>=0 && currRow<rowLen && currCol>=0 && currCol<colLen && maze[currRow][currCol] == 0){
                    currRow += direction[0];
                    currCol += direction[1];
                }
                currRow -= direction[0];
                currCol -= direction[1];
                if(!visited[currRow][currCol]){
                    q.offer(new Pair<>(currRow, currCol));
                    visited[currRow][currCol] = true;
                }
            }
        }
        return false;
    }
}
