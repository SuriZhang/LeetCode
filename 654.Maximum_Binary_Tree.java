/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // return the index in [l,r) with max element
    // why not use Arrays.sort()?
    // Arrays.sort() has a worst case run-time of Θ(nlogn), the following function only takes linear time
    private int maxIndex(int[] nums, int l, int r){
        int index = l;
        for(int i = l; i < r; ++i){
            if(nums[i] > nums[index]) index = i;
        }
        return index;
    }
    
    // construct the tree in nums, leftmost index l, rightmose index r(exclusively)
    private TreeNode construct(int[] nums, int l, int r){
        if(l == r) return null;
        int i = maxIndex(nums, l, r);
        int max = nums[i];
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, l, i);
        root.right = construct(nums, i+1, r);
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        return construct(nums, 0, len);
        
    }
}
