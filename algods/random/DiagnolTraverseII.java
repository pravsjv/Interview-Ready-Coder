package algods.random;
/**
 * Diagnol Traversal II LeetCode 1424
 */

/**
 * Thoughts:
 * BFS ensures that all cells along the diagonal are visited, and since the sum of row and column indices remains constant for each cell on the diagonal, marking visited nodes is unnecessary.
 * Starting from the top-left corner (0, 0), the algorithm iteratively explores the diagonal path by incrementing the row index when the column index reaches zero and the row index is within the matrix bounds. Conversely, it increments the column index when the column index is valid.
 * As the algorithm traverses the matrix, it extracts the elements from the BFS queue and stores them in a list. Once the traversal is complete, an array is created with the same size as the list. Finally, the elements from the list are copied into the array and returned.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class DiagnolTraverseII {
    /**
     * Traverses the given matrix diagonally and returns an array of the elements encountered in diagonal order.
     *
     * @param grid The matrix to traverse.
     * @return An array of the elements encountered in diagonal order.
     * @throws IllegalArgumentException If the matrix is null.
     * Time complexity: O(N) as it requires sorting
     * Space complexity: O(n^1/2) if result storage is not considered else O(N)
     */
    public int[] diagonalTraversal(List<List<Integer>> grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        List<Integer> diagonalElements = new ArrayList<>();
        queue.offer(new Pair<>(0, 0)); // Add the starting position to the queue.

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentPosition = queue.poll(); // Get the next position from the queue.
            int row = currentPosition.getKey();
            int col = currentPosition.getValue();
            diagonalElements.add(grid.get(row).get(col)); // Add the element at the current position to the list.

            if (col == 0 && row + 1 < grid.size()) { // Check if there is a valid element in the bottom-left direction.
                queue.offer(new Pair<>(row + 1, col)); // Add the bottom-left position to the queue.
            }

            if (col + 1 < grid.get(row).size()) { // Check if there is a valid element in the bottom-right direction.
                queue.offer(new Pair<>(row, col + 1)); // Add the bottom-right position to the queue.
            }
        }

        int[] result = new int[diagonalElements.size()]; // Create an array to store the diagonal elements.
        for (int i = 0; i < result.length; i++) { // Copy the elements from the list to the array.
            result[i] = diagonalElements.get(i);
        }

        return result; // Return the array of diagonal elements.
    }
}
