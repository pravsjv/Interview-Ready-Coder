package algods.random;
/**
 * LeetCode 169
 */

 /**
  * Thoughts:
  * Approach 1: Utilizing a HashMap
    Iterate through the array and store each element along with its corresponding frequency in a HashMap.
    Once the array iteration is complete, traverse the HashMap and identify the key (element) whose frequency exceeds half the array's length.
    Analysis:
        Time Complexity: O(N), where N represents the array's length.
        Space Complexity: O(N), as the HashMap utilizes space proportional to the number of distinct elements in the array.
    Approach 2: Leveraging Boyer-Moore Algorithm
        Initialize a counter and a 'candidate' variable to store a potential majority element.
        Iterate through the array and update the counter based on the relationship between the current element and the 'candidate':
            a. If the counter is zero, assign the current element to the 'candidate'.
            b. If the counter is not zero and the current element matches the 'candidate', increment the counter.
            c. If the counter is not zero and the current element differs from the 'candidate', decrement the counter.
        After the array iteration, the 'candidate' is the majority element, assuming it exists. 
        Analysis:
            Time Complexity: O(N), where N represents the array's length.
            Space Complexity: O(1), as the algorithm utilizes constant additional space.
  */
public class MajorityElement {
    /**
    * Finds the candidate element that may be majority.
    * @param nums input array
    * @return candidate majority element or -1 
    * @throws IllegalArgumentException if input is null
   */
    public int majorityElement(int[] nums) {
        if(nums == null)
            throw new IllegalArgumentException("inout cannot be null");
        
        int count = 0;
        int candidate = 0;
        for(int val : nums) {
            candidate = count==0?val:candidate;
            count += candidate==val?1:-1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] arr = new int[]{2,2,1,1,1,2,2};
        System.out.println(obj.majorityElement(arr));
    }
}
