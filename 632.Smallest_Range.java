class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // int array keeping track of current index in each sublist
	int[] next = new int[nums.size()];
	// finished traversing current sublist?
        boolean flag = true;
	// minheap using a PQ
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((i,j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        for(int i = 0; i < nums.size(); ++i) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
	
        for(int i = 0; i < nums.size() && flag; ++i) {
            for(int j = 0; j < nums.get(i).size() && flag; ++j) {
                // min in current level
		int min = queue.poll();
		// we found a smaller range
                if(miny - minx > max - nums.get(min).get(next[min])) {
                    minx = nums.get(min).get(next[min]);
                    miny = max;
                }
		// update index 
                next[min]++;
		// check if at the end of the list
                if(next[min] == nums.get(min).size()) {
                    flag = false;
                    break;
                }
                queue.offer(min);
                max = Math.max(max, nums.get(min).get(next[min]));
            }
        }
        return new int[] {minx, miny};
    }
}
