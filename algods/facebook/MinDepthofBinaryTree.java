package algods.facebook;
/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Leetcode: 111
 */
/**
 * Thoughts:
 *  if the root.left is null, return the right tree else if root.right is null, return root.left
 *  if both are not nul, return the min height after traversing all the nodes in the binary tree
 */
public class MinDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        return minHeight(root);
    }

    private int minHeight(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null)
            return 1+minHeight(root.right);
        if(root.right == null)
            return 1+minHeight(root.left);

        return Math.min(minHeight(root.left),minHeight(root.right))+1;
    }
}
