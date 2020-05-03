/*
*
* Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
* Note that after backspacing an empty text, the text will continue empty.
Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
Example 2:
    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".
Example 3:
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
Example 4:
    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
* */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return convert(S).equals(convert(T));
    }
    public String convert(String str) {
        StringBuilder returnString = new StringBuilder();
        int position = 0;
        for (int i = 0; i<str.length(); i++) {
            char currentChar = str.charAt(i);
            if ( currentChar== '#') {
                if (position > 0) {
                    position--;
                    returnString.deleteCharAt(position);
                }
            } else {
                returnString.append(currentChar);
                position++;
            }
        }
        return returnString.substring(0,position);
    }
}
