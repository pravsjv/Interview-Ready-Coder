package algods.graphs;

public class GraphValidTree {
    // A grpah is said to be a valid if there are no cycles in the graph and as well all the nodes are connected
    //In other words, the graph will be a valid tree if the edges are equal to n-1.
    // less than n-1 confirms that all nodes are not connected
    // greater than n-1 confirms that there are cycles
    public boolean validTree(int n, int[][] edges) {
        if(n-1 > edges.length)
            return false;

        QuickUnionRankOpt uf = new QuickUnionRankOpt(n);
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if(!uf.unionBoolean(x, y)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        GraphValidTree obj = new GraphValidTree();
        System.out.println("Is the given input a valid tree? "+obj.validTree(n, edges));
    }
}
