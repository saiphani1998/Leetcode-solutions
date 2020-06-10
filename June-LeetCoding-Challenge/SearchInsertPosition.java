/*
* Given a sorted array and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.
* You may assume no duplicates in the array.
* Example 1:
    Input: [1,3,5,6], 5
    Output: 2
* Example 2:
    Input: [1,3,5,6], 2
    Output: 1
* Example 3:
Input: [1,3,5,6], 7
Output: 4
* Example 4:
    Input: [1,3,5,6], 0
    Output: 0
*
* Approach: Binary Search approach.
    * If found return that index
    * else return low if low is less than array length or arr[low] < target
    * else return low+1
* */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid = 0;
        while(low <= high) {
            mid = low+((high-low)/2);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low >= nums.length || nums[low] > target) ? low : low + 1;
    }
}
