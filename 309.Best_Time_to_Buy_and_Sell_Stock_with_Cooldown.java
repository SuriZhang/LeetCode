class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int n = prices.length; 
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        
        // base cases
        s0[0] = 0;
        s1[0] = 0 - prices[0]; 
        s2[0] = Integer.MIN_VALUE;
        
        for(int i = 1; i < n; ++i) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];
        }
        
        return Math.max(s0[n-1],s2[n-1]);
    }
}
