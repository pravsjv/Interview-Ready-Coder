package algods.facebook.mostfrequent;
/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 * Leetcode: 339
 */
import java.util.List;
import java.util.LinkedList;

/**
 * Decoding the question
 * - Input: given nested list of integers
 *      Each element in the list is either an integer or a  list recursively
 *      Depth of an integer is the number of lists that it is inside of
 * - Output: Sum of each integer in the nested list
 */
public class NestedListWeightSum {
    public int depthSumBFS(List<NestedInteger> nestedList) {
        if(nestedList == null)
            throw new IllegalArgumentException("Input cannot be null.");

        var q = new LinkedList<NestedInteger>();
        int depth = 1;
        int result = 0;
        q.addAll(nestedList);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                NestedInteger nestedVal = q.poll();
                if(nestedVal.isInteger()){
                    result += nestedVal.getInteger()*depth;
                } else {
                    q.addAll(nestedVal.getList());
                }
            }
            depth++;
        }
        return result;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    public int depthSumDFS(List<NestedInteger> nestedList) {
        if(nestedList == null)
            throw new IllegalArgumentException("Input cannot be null.");

        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth){
        int result = 0;
        
        for(NestedInteger nestedVal : nestedList) {
            if(nestedVal.isInteger()){
                result += nestedVal.getInteger()*depth;
            } else {
                result += dfs(nestedVal.getList(), depth+1);
            }
        }
        return result;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N) for recursion
}
