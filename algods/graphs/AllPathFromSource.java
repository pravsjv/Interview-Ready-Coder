/**
 * All Paths from Source to Target
 * LeetCode 797
 */
package algods.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSource {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0)
            throw new IllegalArgumentException("Input cannot be null.");
        
        dfs(graph, 0, new ArrayList<>());
        return paths;
    }
    private void dfs(int[][] graph, int node, List<Integer> path){
        path.add(node);
        if(node == graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] neighbors = graph[node];
        for(int neighbor : neighbors){
            dfs(graph,neighbor,path);
            path.remove(path.size()-1);
        }
    }
}
