package algods.random;
import java.util.Arrays;
/**
 * Thoughts:
 *  - As its time based question, we need to sort the data/logs based on times
 *  - Now if we spread the logs nodes(index 1 & 2) in a graph, then if we observe everytime a friendship is made, number of nodes reduce.
 *  - When will all the nodes become friends? - when the nodes count is 1 (one connected component)
 *  - So if we use disjoint sets by reducing the number of nodes every time a friendship is made.
 *  - Now when this node count reaches 1, all the nodes are connected and hence return that time(index 0)
 */
public class EarliestFriendsTime {
    public int earliestAcq(int[][] logs, int n) {
        if(logs == null || n<=0)
            throw new IllegalArgumentException("Input cannot be null.");

        QuickUnionRankOpt uf = new QuickUnionRankOpt(n);
        // sort the logs based on timeline
        Arrays.sort(logs,(a,b) -> Integer.compare(a[0],b[0]));
        for(int[] log : logs) {
            uf.union(log[1], log[2]);
            if(uf.getCount() == 1)
                return log[0];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}};;
        int nodes = 6;
        EarliestFriendsTime obj = new EarliestFriendsTime();
        System.out.println("Earliest time when all the nodes became friends: "+obj.earliestAcq(logs, nodes));
    }
}
