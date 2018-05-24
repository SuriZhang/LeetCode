class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> s, boolean[] visited, int[] nums, int pos, int iter){
        result.add(new ArrayList<>(s));
        if(pos == nums.length) return;
        for(int i = iter; i < nums.length; ++i) {
            if(visited[i] || (i > 0 && nums[i-1] == nums[i] && visited[i-1]==false)) continue;
            s.add(nums[i]);
            visited[i] = true;
            backtrack(result, s, visited, nums, pos+1, i);
            s.remove(s.size()-1);
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<Integer>(), visited, nums, 0, 0);
        return result;
    }
}
