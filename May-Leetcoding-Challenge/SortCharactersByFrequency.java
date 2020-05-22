/*
* Given a string, sort it in decreasing order based on the frequency of characters.
    * Example 1:
    Input: "tree"
    Output: "eert"
    Explanation:
        'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    * Example 2:
    Input: "cccaaa"
    Output: "cccaaa"
    Explanation:
        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
        Note that "cacaca" is incorrect, as the same characters must be together.

    * Example 3:
    Input: "Aabb"
    Output: "bbAa"
    Explanation:
        "bbaA" is also a valid answer, but "Aabb" is incorrect.
        Note that 'A' and 'a' are treated as two different characters.
* */

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map =new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }

        List<Map.Entry<Character,Integer>> sortedlist = new ArrayList<>(map.entrySet());
        Collections.sort(sortedlist, new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        String lastString="";
        for (Map.Entry<Character,Integer>  e : sortedlist)
        {
            for(Integer j=0;j <  e.getValue();j++)
                lastString+= e.getKey().toString();
        }
        return lastString;
    }
}
