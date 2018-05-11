class Solution {
    // since the time complexity requires < O(n^2) => binarySearch O(nlogn)
    // cannot sort as we cannot modify the array
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 1;
        int hi = n-1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int count = 0;
            for(int i : nums){
                if(i <= mid) count++;
            }
            if(count <= mid){ 
                // the duplicate does not exist in range lo-mid
                lo = mid + 1;
            } else {
                // the duplicate exists in range lo-mid
                hi = mid;
            }
        }
        return lo;
    }
}
