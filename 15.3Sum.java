class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int sum2 = -nums[i];
			int p1 = i + 1; // ptr from next index
			int p2 = nums.length - 1; // ptr from array end
			while (p1 < p2) {
				int sum = nums[p1] + nums[p2];
				if (sum == sum2) {
					result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
					int prevP1 = p1;
					while (p1 < p2 && nums[p1] == nums[prevP1]) 
						p1++;
					p2--;
				} else if (sum < sum2) {
					p1++;
				} else if (sum > sum2) {
					p2--;
				}
			}
			int prevI = i;
			while (i < nums.length && nums[i] == nums[prevI]) i++;
			i--;
		}
		return result;
	}
}
