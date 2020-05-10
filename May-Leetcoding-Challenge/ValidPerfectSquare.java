/*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.
* Note: Do not use any built-in library function such as sqrt.
*
* */

class Solution {
    public boolean isPerfectSquare(int num) {
        /*
         * Binary Serach Implementation
         * */
        // if (num<1) {
        //     return false;
        // }
        // int start = 0, end = num, mid = 0;
        // while (start <= end) {
        //     mid = start + (end - start)/2;
        //     if (mid*mid == num)
        //         return true;
        //     else if (mid*mid < num) {
        //         start = mid + 1;
        //     }
        //     else {
        //         end = mid - 1;
        //     }
        // }
        // return false;

        /*
        * Newton's method of approximation
        * */
        double r = num;
        while (r*r > num) {
            r = Math.floor((r + (double)(num/r))/2);
        }
        return r*r == num;
    }
}
