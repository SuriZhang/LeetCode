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
    private int add(TreeNode root, int curSum){
        // base case: empty tree
        if(root == null) return 0;
        curSum = curSum * 10 + root.val;
        // already at leaf level, return
        if(root.left == null && root.right == null) return curSum;
        // recurse on both children
        int lsum = add(root.left, curSum);
        int rsum = add(root.right, curSum);
        return lsum + rsum;
    }
    public int sumNumbers(TreeNode root) {
        return add(root, 0); 
    }
}
