/*
* Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
* You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character
* Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
* Example 2:
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
*
* Approach: Traverse from left corner, there are two possibilities for every pair of character being traversed.
        m: Length of str1 (first string)
        n: Length of str2 (second string)
    * If last characters of two strings are same, nothing much to do.
        * Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
    * Else (If last characters are not same), we consider all operations on ‘str1’,
        * consider all three operations on last character of first string, recursively compute minimum cost for all three operations and
        * take minimum of three values.
            * Insert: Recur for m and n-1
            * Remove: Recur for m-1 and n
            * Replace: Recur for m-1 and n-1
    *
* */

class Solution {
    public int minDistance(String word1, String word2) {
        return minDistanceUtil(word1, word2, word1.length(), word2.length());
    }
    public int minDistanceUtil(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], // Insert
                            Math.min(dp[i - 1][j], // Remove
                                    dp[i - 1][j - 1])); // Replace
                }
            }
        }
        return dp[m][n];
    }
}
