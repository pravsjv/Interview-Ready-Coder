package algods.random;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This class provides a method to simplify a given filesystem path.
 *
 * @author Praveen Kumar JV
 */
public class SimplifyPath {
    /**
     * Simplifies the given file system path, removing unnecessary directory components and collapsing consecutive slashes.
     *
     * @param path The input path to simplify.
     * @return The simplified path.
     */
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Deque<String> queue = new LinkedList<>(); // A stack to store directory components
        for (String dir : path.split("/")) { // Split the path into individual directory components
            if (dir.equals("..")) { // Encountered a ".." directory, indicating going up a level
                if (!queue.isEmpty()) { // Remove the last directory from the stack
                    queue.poll();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) { // Valid directory component
                queue.push(dir); // Add the directory component to the stack
            }
        }

        StringBuilder simplifiedPath = new StringBuilder(); // A string builder to construct the simplified path
        while (!queue.isEmpty()) { // Construct the simplified path from the stack
            simplifiedPath.append("/");
            simplifiedPath.append(queue.pollLast());
        }

        // Handle the empty path case
        if (simplifiedPath.length() == 0) {
            return "/";
        }

        return simplifiedPath.toString(); // Return the simplified path
    }
}

