/*
* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
*
* */

class Solution {
    public int firstUniqChar(String s) {
        int i = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                map.remove(currentChar);
                set.add(currentChar);
            } else {
                if (!set.contains(currentChar)) {
                    map.put(currentChar, i);
                }
            }
        }
        int low = Integer.MAX_VALUE;
        for (Map.Entry mapElement : map.entrySet()) {
            int currentValue = (int)mapElement.getValue();
            if (currentValue < low) {
                low = currentValue;
            }
        }
        return low<s.length() ? low : -1;
    }
}
