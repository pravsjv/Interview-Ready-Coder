package algods.BinaryTrees;

public class Diameter {
    private int diameter;
    public int diameter(TreeNode root){
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        diameter = Math.max(lh+rh, diameter);

        return 1+Math.max(lh,rh);
    }
}
