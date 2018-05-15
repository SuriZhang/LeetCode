// https://www.geeksforgeeks.org/level-order-tree-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            // size of current level
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }
}

// the problem was how to sperate each level => keep track of the size of the array ie. how many nodes there are on this level
// queue is updated when current level is stored to a list => loop again
