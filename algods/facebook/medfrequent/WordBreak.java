package algods.facebook.medfrequent;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        if(s == null || wordDict.isEmpty())
            throw new IllegalArgumentException("Input cannot be null.");

        Set<String> words = new HashSet<>(wordDict); // O(m*k) both space and time complexity
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[s.length()+1];

        q.add(0);

        while(!q.isEmpty()){ // There are N nodes to traverse and Time Complexity of O(N)
            int left = q.poll();

            if(left == s.length())
                return true;

            for(int right=left+1; right<=s.length(); right++){ // Traversing the string from left to right takes O(N) time complexity
                if(seen[right])
                    continue;

                if(words.contains(s.substring(left,right))){ // creating a substring creates O(N)
                    seen[right] = true;
                    q.add(right);
                }
            }
        }
        return false;
    }
    //Time Complexity: O(n^3+m*k) Overall BFS takes O(N^3) and Storing the elements in hashset takes O(M*K)
    // Space Complexity: O(n+m*k)

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("pravs");
        wordDict.add("kish");

        WordBreak obj = new WordBreak();
        System.out.print(obj.wordBreak(s, wordDict));
    }
}
