package algods.facebook.mostfrequent;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
/**
 * If two nodes are in the same row, then the order should be from left to right
 * Leetcode: 314
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        var map = new HashMap<Integer,List<Integer>>();
        while(!q.isEmpty()){
            Pair p = q.poll();
            root = p.node;
            int col = p.col;

            map.putIfAbsent(col, new ArrayList<Integer>());
            map.get(col).add(root.val);

            minCol = minCol>col?col:minCol;
            maxCol = maxCol<col?col:maxCol;

            if(root.left != null)
                q.offer(new Pair(root.left,col-1));
            
            if(root.right != null)
                q.offer(new Pair(root.right,col+1));

        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=minCol; i<=maxCol; i++){
            result.add(map.get(i));
        }
        return result;
    }

    private class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
}


