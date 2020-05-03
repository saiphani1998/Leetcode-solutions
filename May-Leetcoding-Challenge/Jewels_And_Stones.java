/*
* You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
* Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
* The letters in J are guaranteed distinct, and all characters in J and S are letters.
* Letters are case sensitive, so "a" is considered a different type of stone from "A".
* Example 1:
    Input: J = "aA", S = "aAAbbbb"
    Output: 3
* Example 2:
    Input: J = "z", S = "ZZ"
    Output: 0
*
* Approach:
    Create a set to hold all the jewels and traverse through the stones and
    Check if the set contains each stone and increase the jewel count accordingly.
*
* */

class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (int i=0; i<J.length(); i++) {
            jewelSet.add(J.charAt(i));
        }
        int jewelCount = 0;
        for (int i=0; i<S.length(); i++) {
            if (jewelSet.contains(S.charAt(i))) {
                jewelCount++;
            }
        }
        return jewelCount;
    }
}
