class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        // traverse from leftmost index up to i exclusively
        for(int i = 1; i < n; ++i){
            // output[i] stores the product of nums before itself
            output[i] = output[i-1] * nums[i-1];
        }
        int right = 1;
        // traverse from right
        for(int i = n-1; i >= 0; --i){
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}

// idea: we can divide the problem to find the product of nums before index i, and the product of nums after index i
// simple ver: creating 2 arrays product_before and product_after and iterate in both directions from nums[], then we return the array with output[i] = before[i] * after[i]
//  O(n) time complexity and  O(n) extra space

// a better ver(O(1) extra space): traverse from left first save the product in the array and use a var RIGHT to traverse from the right end.
