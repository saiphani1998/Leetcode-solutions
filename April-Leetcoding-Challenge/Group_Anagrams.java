/*
* Given an array of strings, group anagrams together.
* Example:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
* Note:
    All inputs will be in lowercase.
    The order of your output does not matter.
* Approach:
    Take a hashmap and store every string into the list that is mapped with the key formed by sorting the chars of the string.
    So, now the strings that are anagrams are stored in the list against the common key formed out of sorting the chars of the string.
* */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> mapList = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newWord = new String(chars);

            if(mapList.containsKey(newWord)) {
                mapList.get(newWord).add(str);
            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                mapList.put(newWord,tempList);
            }
        }
        for (String s : mapList.keySet()) {
            resultList.add(mapList.get(s));
        }
        return resultList;
    }
}
