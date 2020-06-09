/*
* Given a string s and a string t, check if s is subsequence of t.
* A subsequence of a string is a new string which is formed from the original string by deleting some
* (can be none) of the characters without disturbing the relative positions of the remaining characters.
* (ie, "ace" is a subsequence of "abcde" while "aec" is not).
* Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and
* you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
* Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true
* Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false
*
* Approach: Take two pointers, one for subsequece and other for main strings.
    * If both the chars that the pointers pointing to match, then increment both, else increment only pointer to main string.
    * Terminate the loop if any string pointer is pointing to end of string.
    * If the sequence pointer had reached end then it is subsequence of main string else not a subsequence.
* */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int slength = s.length(), tlength= t.length();
        for (i = 0; i<tlength && j<slength; i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;;
            }
        }
        return (j >= slength);
    }
}
