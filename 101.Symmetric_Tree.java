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
    private boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        else return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        boolean res = false;
        // tree is empty
        if(root == null) res = true;
        // both children are null
        else if (root.left == null && root.right == null) res = true;
        // both children are not null
        else if(root.left != null && root.right != null){
            // check children's values
            if(root.left.val == root.right.val){
                // current level is symmetric, recursion onto lower levels
                res = check(root.left, root.right);
            } else res = false;
        } 
        // missing one children
        else res = false;
        return res;
    }
}
