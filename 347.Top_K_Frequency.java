class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // count freq: key - num, value - freq
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        
        // sort by freq
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
}
