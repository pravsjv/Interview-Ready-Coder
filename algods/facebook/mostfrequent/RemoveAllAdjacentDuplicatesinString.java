package algods.facebook.mostfrequent;
import java.util.ArrayDeque;
/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * Leetcode: 1209
 */

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesinString {
    public String removeDuplicates(String s, int k) {
        if(s == null || k<0)
            throw new IllegalArgumentException("Input is invalid.");

        if(k==0)
            return s;

        Stack<Pair> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if( stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c,1));
            } else 
                if(++stack.peek().count == k ){
                    stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            for(int i=0; i<p.count; i++)
                result.append(p.c);
        }
        return result.reverse().toString();
    }

    class Pair {
        int count;
        char c;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        RemoveAllAdjacentDuplicatesinString obj = new RemoveAllAdjacentDuplicatesinString();

        System.out.println(obj.removeDuplicates(s, k));
    }
}
