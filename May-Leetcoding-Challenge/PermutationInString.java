/*
* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
* In other words, one of the first string's permutations is the substring of the second string.
* Example 1:
    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").
* Example 2:
    Input:s1= "ab" s2 = "eidboaoo"
    Output: False
* Note:
    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].
*
* Approach: To determine if a string is permutation of other, both equal length strings should have save frequencies of letters present.
    * So we can use Sliding Window Approach with the window size matching length(s1).
    * Also, instead of making use of a special HashMap data structure just to store the frequency of occurence of characters,
    * we can use a simpler array data structure to store the frequencies.
    * Then we just need to compare the two map is the same or not.
* */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) {
            return false;
        }

        int[] s1Map = new int[26];
        // Initialize the frequencies of chars in s1
        for (int i = 0; i<s1Len; i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }

        int[] s2Map = new int[26];
        // Initialize the frequencies of chars in s2 for initial window size, i.e., length(s1)
        for (int i = 0; i<s1Len; i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i< s2Len - s1Len; i++) {
            // If the frequencies matches, it means that the permutation exist
            if (isMatch(s1Map,s2Map)) {
                return true;
            }
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new window
            s2Map[s2.charAt(i) - 'a']--;
            s2Map[s2.charAt(i+s1Len) - 'a']++;
        }

        if (isMatch(s1Map,s2Map)) {
            return true;
        }
        return false;
    }

    public boolean isMatch (int[] a1, int[] a2) {
        for (int i = 0; i<a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
