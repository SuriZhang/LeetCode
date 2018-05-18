class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        // check beginning
        if(nums[0] != nums[1]) return nums[0];
        // check main array
        for(int i = 1; i < nums.length - 1; ++i) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i + 1]) return nums[i]; 
        }
        // check end 
        if(nums[nums.length - 2] != nums[nums.length - 1]) return nums[nums.length - 1];
        return -1;
    }
}

// alt. solution using just math
public int singleNumber(int[] nums) {
        int result=0;
        for(int num : nums) {
            result=result^num;
        }
        return result;
}
