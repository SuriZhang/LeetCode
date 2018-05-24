class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> s, boolean[] visited, int[] nums, int pos){
        if(pos == nums.length) {
            result.add(new ArrayList<>(s));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(visited[i] || (i > 0 && nums[i-1] == nums[i] && visited[i-1] == false)) continue;
            s.add(nums[i]);
            visited[i] = true;
            backtrack(result, s, visited, nums, pos+1);
            visited[i] = false;
            s.remove(s.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        boolean[] visited = new boolean[nums.length]; // initialized to all false by default
        backtrack(result, new ArrayList<Integer>(), visited, nums, 0);
        return result;
    }
}
