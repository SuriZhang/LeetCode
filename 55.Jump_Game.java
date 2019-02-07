class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farest = 0;
        for(int i = 0; i < n; ++i) {
            if(farest < i) return false;
            farest = Math.max(farest, nums[i] + i);
        }
        return true;
    }
}
