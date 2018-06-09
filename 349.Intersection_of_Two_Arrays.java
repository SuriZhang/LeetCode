class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for(int i : nums1) {
            set1.add(i);
        }
        for(int i : nums2) {
            if(set1.contains(i)) intersection.add(i);
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for(int j : intersection) {
            result[i++] = j;
        }
        return result;
    }
}
