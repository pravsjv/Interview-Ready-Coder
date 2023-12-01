package algods.strings;

/**
 * **Thoughts:**
 *
 * The problem of determining whether a given string has a repeated substring pattern can be efficiently solved by exploiting two key observations:
 *
 * **Observation 1:** A string cannot have a pattern that is longer than half of its length. This implies that the maximum possible length of the repeating pattern is half the length of the string.
 *
 * **Observation 2:** A string cannot be formed by repeating a pattern if the length of the pattern is not a divisor of the string's length. This means that if the length of the pattern does not divide evenly into the string's length, it is not possible to create the string by repeating the pattern.
 *
 * Based on these observations, the algorithm utilizes a nested loop approach to check for potential patterns. The outer loop iterates through the first half of the string, representing the potential pattern length. For each value of the pattern length, the inner loop iterates through the string in increments of the pattern length, constructing a potential pattern string and checking if it matches the original string.
 *
 * If a match is found, the function returns `true`, indicating that the string has a repeated substring pattern. Otherwise, if the entire loop completes without finding a match, the function returns `false`, indicating that the string does not have a repeated substring pattern.
 */
public class RepeatedSubStringPattern {

    /**
     * Determines whether a given string has a repeated substring pattern.
     *
     * @param s The input string to be analyzed
     * @return `true` if the string has a repeated substring pattern, `false` otherwise
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        int len = s.length();

        // Iterate through potential pattern lengths (up to half the string length)
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) { // Check if pattern length is a divisor of string length
                StringBuilder pattern = new StringBuilder();

                // Construct the potential repeating pattern
                for (int j = 0; j < len / i; j++) {
                    pattern.append(s.substring(0, i));
                }

                // Check if the constructed pattern matches the original string
                if (s.equals(pattern.toString())) {
                    return true;
                }
            }
        }

        return false; // No pattern found
    }

    public static void main(String[] args) {
        RepeatedSubStringPattern obj = new RepeatedSubStringPattern();

        String s = "abcdabcdabcd";
        // Positive case
        System.out.println("Given string has a pattern: " + obj.repeatedSubstringPattern(s));

        String s2 = "abcdefghi";
        // Negative case
        System.out.println("Given string has a pattern: " + obj.repeatedSubstringPattern(s2));
    }
}

// Time Complexity: O(N*N^1/2)
// Space Complexity: O(N)
