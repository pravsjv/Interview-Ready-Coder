package algods.facebook;

import java.util.Stack;
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root){
        this.stack = new Stack<>();

        leftMostInOrder(root);
    }
    private void leftMostInOrder(TreeNode root){
        while(root != null){
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = this.stack.pop();
        if(node.right != null)
            this.stack.push(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return this.stack.size()>0;
    }

    public static void main(String[] args) {
        // Test case 1: Empty binary tree
        TreeNode root1 = null;
        BinarySearchTreeIterator iterator1 = new BinarySearchTreeIterator(root1);
        System.out.println("Empty tree: hasNext() - " + iterator1.hasNext());

        // Test case 2: Single node binary tree
        TreeNode root2 = new TreeNode(10);
        BinarySearchTreeIterator iterator2 = new BinarySearchTreeIterator(root2);
        System.out.println("Single node tree: next() - " + iterator2.next());
        System.out.println("Single node tree: hasNext() - " + iterator2.hasNext());

        // Test case 3: Balanced binary tree
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(8);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(4);
        root3.right.left = new TreeNode(7);
        root3.right.right = new TreeNode(9);

        BinarySearchTreeIterator iterator3 = new BinarySearchTreeIterator(root3);
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println();
    }
}
