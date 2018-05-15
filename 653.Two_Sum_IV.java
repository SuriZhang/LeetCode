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
    private void toList(TreeNode root, List<Integer> list){
        if(root == null) return;
        toList(root.left, list);
        list.add(root.val);
        toList(root.right, list);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        toList(root, list);
        // cannot use contains, b/c this fails on cases [1], 2
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            int sum = list.get(l) + list.get(r);
            if(sum == k) return true;
            if(sum < k) l ++;
            else r --;
        }
        return false;
    }
}
