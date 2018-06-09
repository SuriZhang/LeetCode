class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        char[] array = s.toCharArray();
        while(r < array.length) {
            map.put(array[r], map.getOrDefault(array[r],0)+1);
            if(map.size() > k) {
                map.put(array[l], map.get(array[l])-1);
                if(map.get(array[l]) == 0) map.remove(array[l]);
                l++;
                r++;
            } else {
                r++;
            }
        }
        return r-l;
    }
}
