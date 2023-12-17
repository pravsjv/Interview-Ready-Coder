package algods.facebook.medfrequent;
/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Leetcode: 129
 */

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        return dfs(root,0);
    }

    private int dfs(TreeNode root, int sum) {
        if(root == null)
            return 0;

        sum = sum*10+root.val;

        if(root.left == null && root.right == null)
            return sum;

        return dfs(root.left, sum)+dfs(root.right, sum);
    }

    public static void main(String[] args) {
        
    }
}
