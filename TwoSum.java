class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement)) {
                return new int[] { hm.get(complement), i };
            }
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution"); 
    }
}

// why not use sort-BinarySearch?
// this question asks for indices in original array, if we sort, then the array is changed// unable to trace back its original indices.
// brute force will work, but takes O(n^2)
// using hashmap takes O(n) as each look up takes O(1), space complexity takes O(n)
