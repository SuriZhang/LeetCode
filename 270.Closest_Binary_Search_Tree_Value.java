/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// idea: calculate the distance between current node and target, return the node.val with minimun dist.
// update the node according to BST properties.

class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode node = root;
        while(node != null){
            if(Math.abs(target - node.val) < Math.abs(target - res)){
                res = node.val;
            }
            if(node.val > target) node = node.left;
            else node = node.right;
        }
        return res;
    }
}
