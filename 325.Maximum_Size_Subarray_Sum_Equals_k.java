/* credit to xuyirui
 * Idea: 
 *  preprocess the input array into range sum array - can be done in O(1)
 *  S[i] = sum from index 0 to i inclusively
 *  => S[j] - S[i - 1] = sum from i to j
 *  => j - i is the len of subarray, we want: max j-i
 *  for any S[j], check if there exist a previous i such that S[j]- S[i] = k
 *  !!!!! USE HASHMAP FOR FASTER LOOK UP INSTEAD OF LOOPS !!!!!!!
 */

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                // this line explains why we need to put(0,-1) into the map first, cuz we can say that if nums[i] - k == 0 then the index from 0 to i will make to sum k
		max = Math.max(max, i - map.get(nums[i] - k));
			
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);
        }
        return max;
    }
} 

