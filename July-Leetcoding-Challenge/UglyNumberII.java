/*
* Write a program to find the n-th ugly number.
* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
* Example:
    Input: n = 10
    Output: 12
    Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
* Note:
    1 is typically treated as an ugly number.
    n does not exceed 1690.
* */

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int num2 = dp[index2]*2;
        int num3 = dp[index3]*3;
        int num5 = dp[index5]*5;
        for(int i = 1; i < n; i++ ) {
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if(dp[i] == num2) {
                index2++;
                num2 = dp[index2]*2;
            }
            if(dp[i] == num3) {
                index3++;
                num3 = dp[index3]*3;
            }
            if(dp[i] == num5) {
                index5++;
                num5 = dp[index5]*5;
            }
        }
        return dp[n-1];
    }
}
