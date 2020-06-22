/*
* Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
* Find that single one.
* Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

* Example 1:
    Input: [2,2,3,2]
    Output: 3
* Example 2:
    Input: [0,1,0,1,0,1,99]
    Output: 99
* */

class Solution {
    public int singleNumber(int[] A) {
        class Solution {
            public int singleNumber(int[] nums) {
                HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
                for(int num:nums) {
                    map.put(num, map.getOrDefault(num,0)+1);
                }
                int number=-1;
                for(int num : map.keySet()) {
                    if(map.get(num)==1) {
                        return num;
                    }
                }
                return number;
            }
        }
//        int ones = 0, twos = 0, threes = 0;
//        for (int i = 0; i < A.length; i++) {
//            twos |= ones & A[i];
//            ones ^= A[i];
//            threes = ones & twos;
//            ones &= ~threes;
//            twos &= ~threes;
//        }
//        return ones;
    }
}
