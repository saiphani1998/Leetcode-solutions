/*
* Given two binary strings, return their sum (also a binary string).
* The input strings are both non-empty and contains only characters 1 or 0.
* Example 1:
    Input: a = "11", b = "1"
    Output: "100"
* Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"
* Constraints:
    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.
* */

class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        if(m < 1 || n < 1)
            return null;

        if(m < n)
            return addBinary(b, a);

        int carry = 0;
        int j = n - 1;
        StringBuilder sb = new StringBuilder();

        for(int i = m - 1; i >= 0; i--) {
            if(a.charAt(i) == '1')
                carry++;
            if(j > -1 && b.charAt(j--) == '1')
                carry++;

            if(carry % 2 == 1)
                sb.append("1");
            else
                sb.append("0");

            carry /= 2;
        }

        if(carry == 1)
            sb.append("1");

        sb.reverse();

        return sb.toString();
    }
}
