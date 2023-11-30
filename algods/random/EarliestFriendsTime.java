package algods.random;
import java.util.Arrays;
/**
 * **Thoughts:**
 *
 * The problem of determining the earliest time when all nodes in a social network become friends can be efficiently solved using the disjoint-sets data structure, also known as union-find. Disjoint-sets is a data structure that maintains a collection of disjoint sets, where each set represents a group of connected friends in the social network.
 *
 * Since the problem is time-based, we start by sorting the given logs (friendship records) based on their timestamps. This ensures that we consider the friendships in chronological order.
 *
 * We then initialize a disjoint-sets data structure with the specified number of nodes (representing the individuals in the social network). As we iterate through the sorted logs, we perform union operations between the sets containing the individuals involved in each friendship.
 *
 * Performing a union operation combines the two sets into a single larger set, representing the group of friends that are connected through the newly formed friendship. With each union operation, the number of disconnected sets decreases.
 *
 * We continue processing the logs until the number of disjoint sets reaches one. This indicates that all nodes have become friends and are part of a single connected component. The timestamp of the last log processed before reaching this point represents the earliest time when all nodes became friends.
 */
public class EarliestFriendsTime {

    /**
     * Determines the earliest time when all nodes in a social network become friends.
     *
     * @param logs The list of friendship records, each represented as an array of [timestamp, friend1, friend2]
     * @param n The number of nodes in the social network
     * @return The earliest time when all nodes became friends, or -1 if no such time exists
     */
    public int earliestAcq(int[][] logs, int n) {
        if (logs == null || n <= 0) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // Initialize disjoint-sets data structure with n sets
        QuickUnionRankOpt uf = new QuickUnionRankOpt(n);

        // Sort the logs based on timestamp
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] log : logs) {
            uf.union(log[1], log[2]);

            // Check if all nodes are connected (single set)
            if (uf.getCount() == 1) {
                return log[0];
            }
        }

        return -1; // No time when all nodes became friends
    }

    public
 
static
 
void
 
main(String[] args)
 
{
        int[][] logs = {{20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}};
        int nodes = 6;

        EarliestFriendsTime obj = new EarliestFriendsTime();
        System.out.println("Earliest time when all the nodes became friends: " + obj.earliestAcq(logs, nodes));
    }
}
