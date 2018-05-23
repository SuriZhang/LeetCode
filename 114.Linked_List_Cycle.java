/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

// O(1) extra space:
// fast ptr increments 2 at a time, slow ptr increments 1 at a time
// if they eventually meet => there is a cycle
// otherwise => no cycle
