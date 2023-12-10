package algods.facebook;
/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 * LeetCode 865
 */
public class SubTreeWithDeepestNodes {
    /**
     * Decoding the Question:
     * Input : Root of a binary tree
     * Output: return the small tree that contains all the deepest nodes
     * Deepest node is the node that has the largest depth possible in the original tree
     * Thought process:
     *  - find the deepest leaves
     *  - then find the parent of those leaves or lca of those nodes
     * @param root
     * @return
     */
    TreeNode subTree;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        maxDepth = 0;
        dfs(root,0);
        return subTree;
        
    }
    private TreeNode dfs(TreeNode root, int depth){
        if(root == null)
            return null;
        
        if(depth > maxDepth){
            maxDepth = depth;
            subTree = root;
        }

        TreeNode leftSubTree = dfs(root.left, depth+1);
        TreeNode rightSubTree = dfs(root.right, depth+1);

        if(leftSubTree != null && rightSubTree != null){
            return root;
        } else if(leftSubTree != null) {
            return leftSubTree;
        } else {
            return rightSubTree;
        }
    }
}
