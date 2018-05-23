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
    private void addPath(TreeNode node, StringBuilder curPath, List<String> paths) {
        if(node == null) return;
        int temp = curPath.length();
        if(node.left == null && node.right == null) {
            curPath.append(node.val);
            paths.add(curPath.toString());
            curPath.setLength(temp);
            return;
        }
        curPath.append(node.val).append("->");
        addPath(node.left, curPath, paths);
        addPath(node.right, curPath, paths);
        curPath.setLength(temp);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;
        StringBuilder path = new StringBuilder();
        addPath(root, path, paths);
        return paths;
    }
}
