/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String splitter = ",";
    private static final String NULL = "null";
    
    private void buildStr(TreeNode root, StringBuilder s) {
        if(root == null) {
            s.append(NULL).append(splitter);
            return;
        } else {
            s.append(root.val).append(splitter);
            buildStr(root.left, s);
            buildStr(root.right, s);
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder tree = new StringBuilder();
        buildStr(root, tree);
        return tree.toString();
    }
    
    private int index = 0;
    private TreeNode buildTree(String[] str) {
        String cur = str[index++];
        if(cur.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(str);
        root.right = buildTree(str);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(splitter);
        return buildTree(str);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
