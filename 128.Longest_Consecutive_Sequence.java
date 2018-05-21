class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        // put all nums into set
        for(int n : nums) set.add(n);
        
        int longestStreak = 1;
        for(int n : nums) {
            // check in ascending order, start from n-1 (if previous check already counted n)
            if(!set.contains(n-1)){
                int curNum = n;
                int curStreak = 1;
                while(set.contains(curNum+1)) {
                    // update curNum & curStreak count
                    curStreak++;
                    curNum++;
                }
                longestStreak = longestStreak > curStreak ? longestStreak : curStreak;
            }
        }
        return longestStreak;
    }
}
