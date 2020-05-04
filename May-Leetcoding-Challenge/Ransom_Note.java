/*
* Given an arbitrary ransom note string and another string containing letters from all the magazines,
* write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
* Each letter in the magazine string can only be used once in your ransom note.
* Note: You may assume that both strings contain only lowercase letters.
* Examples:
    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
*
* Approach: Store all the characters in the magazine along with the frequencies in the hashmap.
    Now traverse through the ransomnote chars and keep decreasing the frequencies stored in hashmap.
    if at all the character frequency is 0, then return false.
* 
* */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> allowedOccurances = new HashMap<>();
        for (int i = 0; i<magazine.length(); i++) {
            if (allowedOccurances.containsKey(magazine.charAt(i))) {
                allowedOccurances.replace(magazine.charAt(i), allowedOccurances.get(magazine.charAt(i))+1);
            } else {
                allowedOccurances.put(magazine.charAt(i), 1);
            }
        }
        for(int i = 0; i<ransomNote.length(); i++) {
            if (allowedOccurances.getOrDefault(ransomNote.charAt(i),0) > 0) {
                allowedOccurances.replace(ransomNote.charAt(i), allowedOccurances.get(ransomNote.charAt(i))-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
