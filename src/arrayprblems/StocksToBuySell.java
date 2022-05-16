package arrayprblems;

public class StocksToBuySell {

    public int maxProfit(int[] prices) {
        //Maintain minimum buy price
        int minBuyPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        int curProfit = 0;
        int curPrice;
        for(int i = 1 ; i < prices.length; i++){
            curPrice = prices[i];
            curProfit = curPrice - minBuyPrice;
            maxProfit = Math.max(curProfit, maxProfit);
            minBuyPrice = Math.min(curPrice,minBuyPrice);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int[] test1 = {};

    }
}
