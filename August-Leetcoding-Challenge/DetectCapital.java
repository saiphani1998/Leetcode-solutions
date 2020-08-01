/*
* Given a word, you need to judge whether the usage of capitals in it is right or not.
* We define the usage of capitals in a word to be right when one of the following cases holds:
    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    Otherwise, we define that this word doesn't use capitals in a right way.
* Example 1:
    Input: "USA"
    Output: True
* Example 2:
    Input: "FlaG"
    Output: False
* Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
* */

class Solution {
    public boolean detectCapitalUse(String word) {
        int previousCap = -1;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(currentChar >= 'A' && currentChar <= 'Z') {
                if(previousCap + 1 == i) {
                    previousCap++;
                } else {
                    return false;
                }
            }
        }

        if(previousCap == -1 || previousCap == word.length() - 1 || previousCap == 0) {
            return true;
        }

        return false;
    }
}
