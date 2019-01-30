class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, left, i);
				left++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, i, right);
				right--;
			}
		}
    }
}


// another version
public void sortColors(int[] nums) {
		int j = 0, k = nums.length - 1;
		for (int i = 0; i <= k; i++) {
			// 遇到0和前面的交换
			if (nums[i] == 0)
				swap(nums, i, j++);
			// 遇到2和后面的交换
			else if (nums[i] == 2)
				swap(nums, i--, k--);
		}	
}

