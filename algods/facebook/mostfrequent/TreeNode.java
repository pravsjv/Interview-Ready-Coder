package algods.facebook.mostfrequent;

import org.w3c.dom.Node;

public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     public TreeNode parent;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
         this.val = val;
         this.left = left;
         this.right = right;
         this.parent = parent;
     }
}
