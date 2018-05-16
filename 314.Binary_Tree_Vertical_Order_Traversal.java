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
    class Values {
    int max, min;
    }

    // min --> Minimum horizontal distance from root
    // max --> Maximum horizontal distance from root
    // hd  --> Horizontal distance of current node from root 
  
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(TreeNode node, Values min, Values max, int hd) {
        // Base case
        if (node == null) return;
  
        // Update min and max
        if (hd < min.min)  min.min = hd;
        else if (hd > max.max)  max.max = hd;
  
        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
  
    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void insertCol(TreeNode node, int line_no, int hd, List<Integer> col) {
        // List<Integer> col = new ArrayList();
        // Base case
        if (node == null)  return;
        // If this node is on the given line number
        if (hd == line_no) {
            col.add(node.val);  
            // System.out.println("col added : " + node.val);
        }
  
        // Recur for left and right subtrees
        insertCol(node.left, line_no, hd - 1, col);
        insertCol(node.right, line_no, hd + 1, col);
        // System.out.println("col : " + col);
    }
 
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        Values values = new Values();
        findMinMax(root, values, values, 0);
        for (int line_no = values.min; line_no <= values.max; line_no++) {
            // System.out.println("line_no = " + line_no);
            List<Integer> temp = new ArrayList();
            insertCol(root, line_no, 0, temp);
            res.add(temp);
        }
        return res;
    }
}

// idea from https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
// 200 / 212 test cases passed
// failed case:
/*
Input:
[3,9,8,4,0,1,7,null,null,null,2,5]
Output:
[[4],[9,5],[3,0,1],[2,8],[7]]
Expected:
[[4],[9,5],[3,0,1],[8,2],[7]]
*/
