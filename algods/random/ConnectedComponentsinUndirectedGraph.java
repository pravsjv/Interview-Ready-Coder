package algods.random;
/**
 * **Thoughts:**
 *
 * The problem of finding connected components in an undirected graph can be efficiently solved using the disjoint-sets data structure, also known as union-find. Disjoint-sets is a data structure that maintains a collection of disjoint sets, where each set represents a connected component in the graph.
 *
 * To determine the number of connected components in the graph, we perform unions between pairs of vertices based on the given edges. Each union operation combines two connected components into a single larger component.
 *
 * Initially, each vertex belongs to its own separate set. When an edge exists between two vertices, it indicates that they are connected and should belong to the same connected component. Performing a union operation between these two sets merges them into a single component.
 *
 * As we process each edge, the number of components that are not connected decreases. Once all edges have been processed, the remaining number of components represents the total number of connected components in the graph.
 */
public class ConnectedComponentsinUndirectedGraph {

    /**
     * Counts the number of connected components in an undirected graph.
     *
     * @param n The number of vertices in the graph
     * @param edges The list of edges connecting vertices
     * @return The number of connected components in the graph
     */
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        // Initialize disjoint-sets data structure with n sets
        QuickUnionRankOpt obj = new QuickUnionRankOpt(n);

        // Process each edge by performing unions between connected vertices
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            obj.unionConnectedComponents(x, y);
        }

        // The remaining number of components represents the total count
        return obj.getCount();
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        ConnectedComponentsinUndirectedGraph obj = new ConnectedComponentsinUndirectedGraph();
        int count = obj.countComponents(n, edges);
        System.out.println("Number of connected components in an undirected graph: " + count);
    }
}