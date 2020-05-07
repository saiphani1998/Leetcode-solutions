/*
* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
* You may assume that the array is non-empty and the majority element always exist in the array.
Example 1:
    Input: [3,2,3]
    Output: 3
Example 2:
    Input: [2,2,1,1,1,2,2]
    Output: 2
*
* */

class Solution {
    public int majorityElement(int[] nums) {
         HashMap<Integer,Integer> map = new HashMap<>();
         for (int num: nums) {
             if (map.containsKey(num)) {
                 map.replace(num,map.get(num)+1);
             } else {
                 map.put(num,1);
             }
         }
         for (Map.Entry mapElement : map.entrySet()) {
             int currentFrequency = (int)mapElement.getValue();
             if (currentFrequency > nums.length/2) {
                 return (int)mapElement.getKey();
             }
         }
         return -1;
    }
}
