/*
*Say you have an array for which the ith element is the price of a given stock on day i.
* Design an algorithm to find the maximum profit. You may complete as many transactions as you like
* (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

* You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
* After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
* Example:
    Input: [1,2,3,0,2]
    Output: 3
    Explanation: transactions = [buy, sell, cooldown, buy, sell]
* */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int buy1 = -prices[0], buy2 = buy1;
        int sell0 = 0, sell1 = 0, sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy2, sell2 - prices[i]);
            sell0 = Math.max(sell1, buy2 + prices[i]);
            buy2 = buy1;
            sell2 = sell1;
            sell1 = sell0;
        }
        return sell0;
    }
}
