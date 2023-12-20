package algods.facebook.mostfrequent;
/**
 * https://leetcode.com/problems/custom-sort-string/
 * LeetCode: 791
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        if(order == null || s == null)
            throw new IllegalArgumentException("Input cannot be null.");

        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c-'a']++;

        StringBuilder result = new StringBuilder();

        for(char c : order.toCharArray()){
            for(int i=0; i<count[c-'a']; i++){
                result.append(c);
            }
            count[c-'a'] = 0;
        }

        for(char c='a'; c<='z'; c++){
            for(int i=0; i<count[c-'a']; i++){
                result.append(c);
            }
        }

        return result.toString();
    }
}
