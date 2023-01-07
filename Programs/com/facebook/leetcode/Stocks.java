// L.C. 121. Best Time to Buy and Sell Stock
package com.facebook.leetcode;

public class Stocks {
  public static void main(String[] args) {
    Stocks s = new Stocks();
    System.out.println(s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }

  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int max_profit = 0, lowPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {

      if (lowPrice > prices[i]) {
        lowPrice = prices[i];
      } else if (prices[i] - lowPrice > max_profit) {
        max_profit = prices[i] - lowPrice;
      }
    }

    return max_profit;
  }
}
