/*
* The set [1,2,3,…,n] contains a total of n! unique permutations.
* By listing and labeling all of the permutations in order,
* We get the following sequence (ie, for n = 3 ) :
    1. "123"
    2. "132"
    3. "213"
    4. "231"
    5. "312"
    6. "321"
* Given n and k, return the kth permutation sequence.
* For example, given n = 3, k = 4, ans = "231"
* Good questions to ask the interviewer :
    * What if n is greater than 10. How should multiple digit numbers be represented in string?
        In this case, just concatenate the number to the answer.
        so if n = 11, k = 1, ans = "1234567891011"
    * Whats the maximum value of n and k?
        In this case, k will be a positive integer thats less than INT_MAX.
        n is reasonable enough to make sure the answer does not bloat up a lot.
*
* Approach: For example if we have n=4 i.e a set of {1,2,3,4}, and if we need k=14th permutation.
    * For this set below are different groups of permutations, i.e once we select the first digit each group will have n-1 permutations.
        1 + {2,3,4}
        2 + {1,3,4}
        3 + {1,2,4}
        4 + {1,2,3}
    * k=14th permutation falls into the third group of permutations above that begins with digit 3.
    * To obtain this we take (k-1)/factorial(n-1).
    * (k-1 because if we list all possible permutations it begins with k=0 and ends at k=23, i.e total of 24)
    * Once we get the first digit as 3, we have {1,2,4} remaining to choose from, among permutations possible by {1,2,4} k is no longer the 13th,
    * it needs to be updated. We eliminated the first two groups of permutations above so reducing that we get k=1,
    * i.e k = k - (index of digit found * factorial(n-1)) => index of digit found for 13th permutation was 2, k=13-(2*factorial(4-1)).
    * Note:For further iterations update size of n accordingly or use (n-iteration number)
    * Repeating the above process for now n=3 we have 3 groups possible
        1+{2,4}
        2+{1,4}
        4+{1,2}
    * we need k=1 which is the first group, so from the set of {1,2,4} we need index=0 i.e 1.
    * we get that by i=(k-1)/factorial(n-iteration) => i=(1-1)/factorial(4-2) => 0
* */

class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> r = new ArrayList<>();

        for(int i=1;i<=n;i++){
            r.add(i);
        }

        return permutate(r,k-1);
    }

    public String permutate(ArrayList<Integer> input, int k ){
        int n = input.size();
        if (n==0) {
            return "";
        }
        if (k>factorial(n)) {
            return "";
        }
        int f = (int)factorial(n-1);
        int pos = k/f;
        k %= f;

        String ch = String.valueOf(input.get(pos));
        input.remove(pos);
        return ch+permutate(input,k);
    }

    public long factorial(int n){
        long fact = 1;
        for (int i=2;i<=n;i++) {
            fact *= i;
        }
        return fact;
    }
}
