/*
* Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
* Example 1:
    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
* Example 2:
    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
* Note: The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.
*
* Approach: Using bit manupulations, check the LSB value
    if it is 1 then don't add anything to the sum,
    if it is 0 then add the value of 2 raised to the position of that bit
* */

class Solution {
    public int findComplement(int num) {
        int sum = 0, i = 0;
        while (num>0) {
            sum += (num & 1) == 0 ? Math.pow(2,i) : 0;
            num >>= 1;
            i++;
        }
        return sum;
    }
}
