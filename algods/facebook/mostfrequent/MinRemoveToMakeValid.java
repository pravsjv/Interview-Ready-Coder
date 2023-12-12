package algods.facebook.mostfrequent;
/*
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * LeetCode: 1249
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
public class MinRemoveToMakeValid {
    /**
     * Thoughts:
     *  - While traversing the String, using a stack, identify all the parenthesis indices to be removed(hashset)
     *  - Once identified, create a String builder and add all the chars except the chars identified to be removed.
     *  - return result.
     *  - The Time Complexity will O(N) but takes space of O(K) parenthesis to be removed
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        if(s == null)
            throw new IllegalArgumentException("Input cannot be null");

        // create a hashset to store the indices of the parenthesis to be removed.
        Set<Integer> toBeRemoved = new HashSet<>();
        
        // Create a stack to identify the parenthesis to be removed.
        Stack<Integer> stack = new Stack<>();
        // Iterate the String
        for(int i=0; i<s.length(); i++){
            // push the parenthesis to stack
            if(s.charAt(i) == '('){
                stack.push(i);
            // add the index to set if the stack is empty else pop the parenthesis if a match exist
            } else if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    toBeRemoved.add(i);
                else
                    stack.pop();
            }
        }
        // iterate the stack to add the remaining indices to set
        while(! stack.isEmpty())
            toBeRemoved.add(stack.pop());

        // Create a String Builder 
        StringBuilder sb = new StringBuilder();
        
        // Iterate the String and copy all the chars to the StringBuilder that are not present in the set
        for(int i=0; i<s.length(); i++){
            if(!toBeRemoved.contains(i))
                sb.append(s.charAt(i));
        }

        // return result
        return sb.toString();
    }
    // Time Complexity:O(2N)
    // Space Complexity: O(N) as we are using StringBuilder, set and Stack

    public static void main(String[] args){
        String s = "lee(t(c)o)de)";
        MinRemoveToMakeValid obj = new MinRemoveToMakeValid();
        System.out.println("Result using Stack and Set: "+obj.minRemoveToMakeValid(s));

        System.out.println("Result using optimized two pass: "+obj.optimizedTwoPass(s));
    }

    /**
     * Thoughts:
     *  - traverse the string and keep the opening parenthesis and append the chars that are valid(if openseen is 0)
     *  - At the same time keep incrementing two variables such that if a closing parenthesis is a closed one, then decrement the balance.
     *  - With the above iteration, all the closing parenthesis are made valid
     *  - now substract balance from openseen to get open parenthesis to keep
     *  - iterate the string and if the parenthesis is ( , then decrement openTokeep and append to the stringbuilder
     *  - if the openToKeep is less than 0, then start ignoring the chars.
     * @param s
     * @return
     */
    public String optimizedTwoPass(String s) {
        if(s == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int openSeen = 0, balance =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                ++openSeen;
                ++balance;
            } else if(s.charAt(i) == ')'){
                if(openSeen == 0)
                    continue;
                --balance;
            }
            sb.append(s.charAt(i));
        }

        int openToKeep = openSeen-balance;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if(s.charAt(i) == '('){
                --openToKeep;
                if(openToKeep < 0) continue;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
    // Time Complexity: O(N)
    // Space Complexity: O(N)
}
