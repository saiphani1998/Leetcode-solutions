/*
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
*
* Approach:
    if we compare max_so_far with max_ending_here only if max_ending_here is greater than 0.
* */

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for(int i = 1; i<nums.length; i++) {
            maxEndingHere = Math.max(nums[i],maxEndingHere+nums[i]); // This handles the case when the sum is already negative.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
