/*
* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
* Si % Sj = 0 or Sj % Si = 0.
* If there are multiple solutions, return any subset is fine.
* Example 1:
    Input: [1,2,3]
    Output: [1,2] (of course, [1,3] will also be ok)
* Example 2:
    Input: [1,2,4,8]
    Output: [1,2,4,8]
*
* Approach: Sort all array elements in increasing order.
    * The purpose of sorting is to make sure that all divisors of an element appear before it.
    * Create an array divCount[] of same size as input array.
    * divCount[i] stores size of divisible subset ending with arr[i] (In sorted array). The minimum value of divCount[i] would be 1.
    * Traverse all array elements. For every element, find a divisor arr[j] with largest value of divCount[j] and
    * store the value of divCount[i] as divCount[j] + 1.
* */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        if (arr.length == 0) {
            return (new ArrayList<>());
        }
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int divCount[] = new int[arr.length];
        Arrays.fill(divCount, 1);
        int prev[] = new int[arr.length];
        Arrays.fill(prev, -1);
        int max_ind = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && divCount[i] < divCount[j] + 1) {
                    prev[i] = j;
                    divCount[i] = divCount[j] + 1;
                }
            }
            if (divCount[i] > divCount[max_ind]) {
                max_ind = i;
            }
        }

        int k = max_ind;
        while (k >= 0) {
            list.add(0,arr[k]);
            k = prev[k];
        }
        return list;
    }
}
