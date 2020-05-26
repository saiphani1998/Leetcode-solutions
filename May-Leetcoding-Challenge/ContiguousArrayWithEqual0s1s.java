/*
* Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
* Example 1:
    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
* Example 2:
    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
* Note: The length of the given binary array will not exceed 50,000.
*
* Approach:
* */

class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, n = arr.length;
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            if (map.containsKey(sum + n)) {
                if (max_len < i - map.get(sum + n)) {
                    max_len = i - map.get(sum + n);
                    ending_index = i;
                }
            } else {
                map.put(sum + n, i);
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        return max_len;
    }
}
