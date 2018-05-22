class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = nums.length+1;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while(sum >= s) {
                ans = Math.min(ans, i+1-left);
                sum -= nums[left++];
            }
        }
        return ans != nums.length+1? ans : 0;
    }
}
