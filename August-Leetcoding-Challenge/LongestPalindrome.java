/*
* Given a string which consists of lowercase or uppercase letters,
* find the length of the longest palindromes that can be built with those letters.
* This is case sensitive, for example "Aa" is not considered a palindrome here.
* Note: Assume the length of given string will not exceed 1,010.
* Example:
    Input: "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
* */

class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        int x = 0;
        Map<Character, Integer> map = new HashMap();

        for (int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp)+1);
            } else {
                map.put(tmp,1);
            }
        }

        for (Character c : map.keySet()) {
            if (map.get(c)>2) {
                if (map.get(c)%2==0) {
                    count = count + map.get(c);
                } else {
                    count = count + map.get(c) - 1;
                    x = 1;
                }
            } else if (map.get(c)%2==0) {
                count = count + map.get(c);
            } else if (map.get(c)%2==1) {
                x = 1;
            }
        }
        count = count + x;

        return count;
    }
}