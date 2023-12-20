package algods.facebook.medfrequent;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class RightSideViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++){
                root = q.poll();
                if(i == size-1)
                    result.add(root.val);
                if(root.left != null)
                    q.offer(root.left);

                if(root.right != null)
                    q.offer(root.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        RightSideViewBinaryTree obj = new RightSideViewBinaryTree();
        System.out.println(obj.rightSideView(root));
    }
}
