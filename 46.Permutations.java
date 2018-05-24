class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> selected, int[] nums, int pos) {
        if(pos == nums.length) {
            result.add(new ArrayList<Integer>(selected));
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if(selected.contains(nums[i])) continue;
            selected.add(nums[i]);
            backtrack(result, selected, nums, pos+1);
            selected.remove(selected.size()-1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
}
