class Solution {
    private void backtrack(int[] candidates, int remain, int l, List<List<Integer>> list, List<Integer> temp) {
        if(remain < 0) return;
        else if (remain == 0) list.add(new ArrayList(temp));
        else {
            for(int i = l; i < candidates.length; ++i) {
            temp.add(candidates[i]);
            backtrack(candidates, remain-candidates[i], i, list, temp);
            temp.remove(temp.size()-1); // remove the most recently inserted
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList());
        return res;
    }
}


