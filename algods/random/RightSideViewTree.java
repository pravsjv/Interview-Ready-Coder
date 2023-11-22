package algods.random;
/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * LeetCode 199
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Thoughts:
 * - For any tree problems, we have two traversals - depth first search and breadth first search
 * - Specific to this problem, we need values of right side of the tree which can be easily achieved by BFS level by level.
 * - For BFS,
 *      - create a queue and add a root to the queue
 *      - traverse the queue until its empty
 *          - get the size of the queue and traverse the queue
 *              - poll the data from the queue
 *              - if the currentLevel(loop incrementer) is less than q.size()-1(right side element), then add it to result.
 *              - if left child of the root is not null, add left child to queue
 *              - if right child of the root is not null, add right child to the queue.
 *     - return the result
 */
public class RightSideViewTree {
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        if(root == null)
            return result;
        
        // create a queue and add the root
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // iterate the queue till its empty
        while(!q.isEmpty()){
            int currLevel = q.size();
            for(int i=0; i<currLevel; i++){
                root = q.poll();
                // add the value to the result if the node is a right side node of the tree
                if(i == currLevel-1)
                    result.add(root.val);
                // add left child if its not null
                if(root.left != null)
                    q.offer(root.left);
                // add right child if its not null
                if(root.right != null)
                    q.offer(root.right);
            }
        }
        return result;
    }
}
