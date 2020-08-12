/*
* Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
* Note that the row index starts from 0.
* In Pascal's triangle, each number is the sum of the two numbers directly above it.
* Example:
    Input: 3
    Output: [1,3,3,1]
* Follow up: Could you optimize your algorithm to use only O(k) extra space?
* */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}
