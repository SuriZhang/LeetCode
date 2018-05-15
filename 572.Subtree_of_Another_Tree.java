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
    // check the trees s, t are equal, recursively
    private boolean check(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val == t.val){
            return check(s.left, t.left) && check(s.right, t.right);
        } else return false;
    }
    private boolean traverse(TreeNode s, TreeNode t) {
        // t could be a subtree of s, or subtree of s.left, or subtree of s.right
        return s != null && (check(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
}
