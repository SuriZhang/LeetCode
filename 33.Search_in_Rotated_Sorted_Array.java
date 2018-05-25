class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        // find the index of min value using binary search
        while(lo <= hi) {
            int mid = (lo+hi) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < nums[hi]) { // right half is sorted
                if(nums[mid] < target && nums[hi] >= target) { // target lies in the sorted part
                    // regular BinSearch
                    lo = mid+1;
                } else hi = mid-1;
            } else { // left half is sorted
                if(nums[mid] > target && nums[lo] <= target) {
                    hi = mid-1;
                } else lo = mid+1;
            }
        }
        return -1; // not found
    }
}


// be careful with >= and <= in line 10 & 15
