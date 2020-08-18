/*
* Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
* Note that every number in the answer must not have leading zeros except for the number 0 itself.
* For example, 01 has one leading zero and is invalid, but 0 is valid.

* You may return the answer in any order.
* Example 1:
    Input: N = 3, K = 7
    Output: [181,292,707,818,929]
    Explanation: Note that 070 is not a valid number, because it has leading zeroes.
* Example 2:
    Input: N = 2, K = 1
    Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
* Note:
    1 <= N <= 9
    0 <= K <= 9
* */

class Solution {
    int n,k;
    List<Integer> resultList = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        n = N;
        k = K;
        if (n == 1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        for (int i = 1; i<10; i++) {
            dfs(i, n-1);
        }
        int resultArray[] = new int[resultList.size()];
        int index = 0;
        for (int num: resultList) {
            resultArray[index++] = num;
        }
        return resultArray;
    }

    public void dfs(int currentNumber, int digitsLeft) {
        if (digitsLeft == 0) {
            resultList.add(currentNumber);
            return;
        }
        int lastDigit = currentNumber%10;
        if ((lastDigit + k) <= 9) {
            dfs((currentNumber*10) + lastDigit + k, digitsLeft - 1);
        }
        if (((lastDigit - k) >= 0) && k != 0) {
            dfs(currentNumber * 10 + lastDigit - k, digitsLeft - 1);
        }
    }
}
