package algods.facebook.medfrequent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * LeetCode 863
 */
public class AllNodesFromDistanceK {
    private List<Integer> result;
    Map<Integer,List<Integer>> graph;
    Set<Integer> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null)
            throw new IllegalArgumentException("Input cannot be null.");

        result = new ArrayList<>();

        graph = new HashMap<>();
        buildGraph(root, null);

        visited = new HashSet<>();
        visited.add(target.val);

        dfs(target.val, 0, k);

        return result;
    }

    private void buildGraph(TreeNode currNode, TreeNode parent) {
        if(currNode != null && parent != null){
            graph.computeIfAbsent(currNode.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k-> new ArrayList<>()).add(currNode.val);
        }

        if(currNode.left != null)
            buildGraph(currNode.left, currNode);

        if(currNode.right != null)
            buildGraph(currNode.right, currNode);
    }

    private void dfs(int currVal, int distance, int k){
        if(distance == k){
            result.add(currVal);
            return;
        }

        for(int neighbor : graph.getOrDefault(currVal, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(neighbor, distance+1,k);
            }
        }
    }
}
