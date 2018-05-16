// https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
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
    // Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of input node
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // p.right is null, search from root
        TreeNode successor = null;
        while(root != null){
            if(p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            } 
        }
        return successor;
    }
}
