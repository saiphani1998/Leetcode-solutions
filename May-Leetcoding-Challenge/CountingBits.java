/*
* Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
* calculate the number of 1's in their binary representation and return them as an array.
* Example 1:
    Input: 2
    Output: [0,1,1]
* Example 2:
    Input: 5
    Output: [0,1,1,2,1,2]
* Follow up:
    * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
    * But can you do it in linear time O(n) /possibly in a single pass?
    * Space complexity should be O(n).
*
* Approach: For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1's is 1.
    * Any other number can be converted to be 2^m + x. For example, 9=8+1, 10=8+2.
    * The number of 1's for any other number is 1 + number of 1's in x.
* */

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        int p = 1; //p tracks the index for number x
        int pow = 1;
        for (int i=1; i<=num; i++) {
            if (i==pow){
                result[i] = 1;
                pow <<= 1;
                p = 1;
            } else {
                result[i] = result[p]+1;
                p++;
            }
        }
        return result;
    }
}
