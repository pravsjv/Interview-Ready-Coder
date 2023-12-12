package algods.facebook.mostfrequent;
/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 * LeetCode 1650
 */
public class LCABinaryTreeiii {
    /**
     * Thoughts:
     *  - Unlike regular traversal, we don't have a root node with us. 
     *  - But another advantage is that we have a parent.
     *  - So calculate the depth of the of both the nodes
     *  - Balance depths for both the nodes
     *  - Once both nodes are at same level, traverse upwards simultaneously and check for LCA. 
     * @param p
     * @param q
     * @return
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        if(p==null && q == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int d = depth(p)-depth(q);

        if(d > 0){
            p = goUpBy(p, d);
        }

        if(d < 0){
            q = goUpBy(q, -d);
        }

        while(p != null && q != null && p != q){
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    private int depth(TreeNode node) {
        if(node == null)
            return 0;

        int depth = 0;
        while(node != null){
            ++depth;
            node = node.parent;
        }
        return depth;
    }

    private TreeNode goUpBy(TreeNode node, int diff){
        while(diff>0){
            node = node.parent;
            --diff;
        }
        return node;
    }
}
