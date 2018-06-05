class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length == 0) return max;
        
        int lowest = prices[0];
        for(int i = 1; i < prices.length; ++i) {
            max = Math.max(max, prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }
        
        return max;
    }
}
