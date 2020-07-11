/*
* Given a set of distinct integers, nums, return all possible subsets (the power set).
* Note: The solution set must not contain duplicate subsets.
* Example:
    Input: nums = [1,2,3]
    Output:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
* */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Set size of power set of a set with set_size n is (2^n).
        long pow_set_size = (long)Math.pow(2, nums.length);
        int counter, j;
        // Run from counter 000..0 to 111..1
        for(counter = 0; counter < pow_set_size; counter++) {
            List<Integer> tempList = new ArrayList<>();
            for(j = 0; j < nums.length; j++) {
                // Check if jth bit in the counter is set
                // If set then add jth element to templist.
                if((counter & (1 << j)) > 0) {
                    tempList.add(nums[j]);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
