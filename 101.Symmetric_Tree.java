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

// an iterative solution using a queue
// Each two consecutive nodes in the queue should be equal, and their subtrees a mirror of each other. Initially, the queue contains root and root. Then the algorithm works similarly to BFS, with some key differences. Each time, two nodes are extracted and their values compared. Then, the right and left children of the two nodes are inserted in the queue in opposite order. The algorithm is done when either the queue is empty, or we detect that the tree is not symmetric (i.e. we pull out two consecutive nodes from the queue that are unequal).
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}

