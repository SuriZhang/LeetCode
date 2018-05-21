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
    private int count;
    private boolean isUnival(TreeNode root) {
        if(root == null) return true;
        boolean left = isUnival(root.left);
        boolean right = isUnival(root.right);
        if(left && right) { 
            // both children are unival, check with root
            if(root.left != null && root.val != root.left.val) return false;
            if(root.right != null && root.val != root.right.val) return false;
            count++;
            return true;
        } else return false;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnival(root);
        return count;
    }
    
}
