package algods.facebook;
/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * Leetcode: 530
 */

/**
 * Thoughts:
 * Idea here is to traverse the tree and copy all the values to a list and then sort them and then find the difference.
 * Can we avoid the sort part as it takes the TC to O(NlogN)
 * For a BST, if we do an inOrderTraversal, the output would be a sorted array/list.
 */

import java.util.ArrayList;
import java.util.List;

 public class MinimumAbsoluteDifferenceBST {
    
    private List<Integer> list = new ArrayList<Integer>();
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null");

        inOrderTraversal(root);

        int result = Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++)
            result = Math.min(result,list.get(i)-list.get(i-1));

        return result;
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenceBST obj = new MinimumAbsoluteDifferenceBST();
        System.out.println(obj.getMinimumDifference(root));
    }
}
