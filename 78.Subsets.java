class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> s, int[] nums, int pos, int iter) {
        result.add(new ArrayList<>(s));
        if(pos == nums.length) return;
        for(int i = iter; i < nums.length; ++i) {
            if(s.contains(nums[i])) continue;
            s.add(nums[i]);
            backtrack(result, s, nums, pos+1, i);
            s.remove(s.size()-1);
        } 
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0, 0);
        return result;
    }
    
}
