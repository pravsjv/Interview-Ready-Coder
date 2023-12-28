package algods.facebook.mostfrequent;
/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * Leetcode: 236
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode leftPath = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPath = lowestCommonAncestor(root.right, leftPath, q);

        if(leftPath != null && rightPath !=  null)
            return root;
        
        return leftPath == null ? rightPath : leftPath;
    }
}
