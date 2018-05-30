class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        // find the index of min value using binary search
        while(lo <= hi) {
            int mid = (lo+hi) / 2;
            if(nums[mid] == target) return true;
            else if (nums[mid] < nums[hi] || nums[mid] < nums[lo]) { // right half is sorted
                if(nums[mid] < target && nums[hi] >= target) { // target lies in the sorted part
                    // regular BinSearch
                    lo = mid+1;
                } else hi = mid-1;
            } else if(nums[mid] > nums[lo] || nums[mid] > nums[hi]){ // left half is sorted
                if(nums[mid] > target && nums[lo] <= target) {
                    hi = mid-1;
                } else lo = mid+1;
            } else {
                hi--;
            }
        }
        return false; // not found
    }
}

