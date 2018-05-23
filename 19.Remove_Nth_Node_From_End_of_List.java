/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode ptr = start;
        ListNode tail = head;
        for(int i = 0; i < n; ++i){
            tail = tail.next;
        }
        while(tail != null){
            ptr = ptr.next;
            tail = tail.next;
        }
        ptr.next = ptr.next.next;
        return start.next;
    }
}
