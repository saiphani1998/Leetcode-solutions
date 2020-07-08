/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.
* Note: The solution set must not contain duplicate triplets.
* Example: Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
* */

class Solution {
    public List<List<Integer>> threeSum(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<A.length-2;i++) {
            if (i > 0 && A[i]==A[i-1]) continue; // To avoid duplicate triplets

            long target = -1L * (long)A[i]; // To handle Integer overflow situation
            int j = i+1;
            int k = A.length-1;
            while (j<k) {
                if ((long)A[j] + (long)A[k] == target) {  // To handle Integer overflow situation
                    List<Integer> temp = new ArrayList<>();
                    temp.add(A[i]);
                    temp.add(A[j]);
                    temp.add(A[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    while(j<k && A[j] == A[j-1]) {  // To avoid duplicate triplets
                        j++;
                    }
                    while(j<k && A[k] == A[k+1]) {  // To avoid duplicate triplets
                        k--;
                    }
                } else if (A[j] + A[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
