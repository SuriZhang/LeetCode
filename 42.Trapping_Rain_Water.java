class Solution {
    public int trap(int[] height) {
        int ans = 0;
        if(height == null) return ans;
        int n = height.length;
        if(n == 0) return ans;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        // left 
        leftMax[0] = height[0];
        for(int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // right
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; --i) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        
        for(int i = 0; i < n; ++i) {
            ans += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        
        return ans;
    }
}
