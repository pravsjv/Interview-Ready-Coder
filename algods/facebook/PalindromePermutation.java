package algods.facebook;
/**
 * https://leetcode.com/problems/palindrome-permutation/description/
 * Leetcode 266
 */
/**
 * Thoughts:
 *  For even length strings, if the string can be a palindrome, then every char should exist twice
 *  For odd length strings, if the string can be a palindrome, then every char should exist twice except one.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s == null)
            throw new IllegalArgumentException("Input cannot be null.");

        var map = new int[128];
        int count = 0;

        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)]++;
            if(map[s.charAt(i)]%2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    public static void main(String[] args){
        String s = "carerac";
        PalindromePermutation obj = new PalindromePermutation();
        System.out.println("is a palindrome permutation pssible? "+obj.canPermutePalindrome(s));
    }
}
