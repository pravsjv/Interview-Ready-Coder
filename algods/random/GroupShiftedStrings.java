/**
 * https://leetcode.com/problems/group-shifted-strings/
 * LeetCode: 249
 */
package algods.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class provides a method to group strings based on the pattern of character differences.
 *
 * @author Praveen Kumar JV
 */
public class GroupShiftedStrings {
    /**
     * Groups the given strings into categories based on the pattern of character differences.
     *
     * @param strings The array of strings to group.
     * @return A list of lists of grouped strings.
     * @throws IllegalArgumentException If the input array is null.
     */
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null)
            throw new IllegalArgumentException("Input cannot be null.");

        var map = new HashMap<String,List<String>>();

        /*
         * Thoughts:
         * - If we observe the problem and examples carefully, we see a pattern of the sequences like the difference between two chars is same.
         * - As well same length Strings form a same group.
         * - How do we group them? A HashMap! But what is the key that could group them?
         *  - For Key, we can generate a hashValue based on the patter sequence(character differences)
         */
        for (String s : strings) {
            String hashKey = getHashKey(s); // Generate a hash key based on the pattern of character differences

            map.putIfAbsent(hashKey, new ArrayList<>()); // Add a new group if it doesn't exist
            map.get(hashKey).add(s); // Add the string to the corresponding group
        }

        List<List<String>> groups = new ArrayList<>(); // A list to store the grouped strings
        groups.addAll(map.values()); // Add all the groups from the hashmap

        return groups; // Return the list of grouped strings
    }

    /**
     * Generates a hash key based on the pattern of character differences in the given string.
     *
     * @param s The string to generate the hash key for.
     * @return The generated hash key.
     */
    private String getHashKey(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        /*
         * (char)(s.charAt(i)-s.charAt(i-1)+26)%26-'a'
         * - here the difference is done a modulo of 26 but this can result in a negative integer
         * - Hence we add 26 to the difference before modulo
         * - to convert the value to char, we substart 'a'
         */
        for(int i=1; i<chars.length; i++){
            sb.append((char)(chars[i]-chars[i-1]+26)%26-'a');
        }
        return sb.toString();
    }
}
