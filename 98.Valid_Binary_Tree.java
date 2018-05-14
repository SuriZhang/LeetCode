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
    // idea: check the max value on the left tree, if max < root.val
    //       check the min value on the right tree, if min > root.val
    //       BST is valid
    private int getMax(TreeNode node){
        int max = Integer.MIN_VALUE;
        while(node != null){
            if(node.val > max) max = node.val;
            node = node.right;
        }
        return max;
    }
    
    private int getMin(TreeNode node){
        int min = Integer.MAX_VALUE;
        while(node != null){
            if(node.val < min) min = node.val;
            node = node.left;
        }
        return min;
    }
    
    private boolean check(TreeNode root){
        if(root == null) return true;
        if(root.left != null){
            if(getMax(root.left) >= root.val) return false;
        }
        if(root.right != null){
            if(getMin(root.right) <= root.val) return false;
        }
        return check(root.left) && check(root.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        return check(root);
    }
}
