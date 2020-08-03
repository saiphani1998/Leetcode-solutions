/*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* Note: For the purpose of this problem, we define empty string as valid palindrome.
* Example 1:
    Input: "A man, a plan, a canal: Panama"
    Output: true
* Example 2:
    Input: "race a car"
    Output: false
* Constraints: s consists only of printable ASCII characters.
* */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length()-1, n = s.length()-1;
        while (left < right) {
            char leftChar = s.charAt(left), rightChar = s.charAt(right);
            while (!((leftChar >= 'a' && leftChar <='z') || (leftChar >= '0' && leftChar <='9')) && left < right) {
                left++;
                leftChar = s.charAt(left);
            }

            while (!((rightChar >= 'a' && rightChar <='z') || (rightChar >= '0' && rightChar <='9')) && left < right) {
                right--;
                rightChar = s.charAt(right);
            }
            if (left < right) {
                if (leftChar != rightChar) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}
