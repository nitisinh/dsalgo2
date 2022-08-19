package slidingwindow;

import java.util.Arrays;

/*
Problem Statement -
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
    Constraints:
    1 <= prices.length <= 105
    0 <= prices[i] <= 104
 */
public class BestTimeToBuyStock {
    public static int maxProfit(int[] prices) {
        //Basically you want to maximise the profit.
        // Define the variables.
        int buyPrice = prices[0], maximumProfit = 0, todayProfit =0;
        for(int day = 1 ; day < prices.length ; day++ ){
            todayProfit = prices[day] - buyPrice;
            //if today's price is bigger than buy price, it can be potential sell day.
            if(prices[day] > buyPrice){
                //if today's profit is greater than maximum profit, update the maximum profit
                maximumProfit = Math.max(maximumProfit, todayProfit);
            }else{
                //if today's stock price is lower than buy price
                //stock should be bought today and potential sell should be analysed.
                buyPrice = prices[day];
            }
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input : " + Arrays.toString(prices));
        System.out.println("Output : " + maxProfit(prices));
    }
}
