/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 & l2 are sorted
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = null;
        ListNode temp = null;
        ListNode prev = null;
        while(l1 != null && l2 != null){ // when both are not null
            if(l1.val <= l2.val){
                temp = new ListNode(l1.val);
                if(l1 != null) l1 = l1.next;
            } else {
                temp = new ListNode(l2.val);
                if(l2 != null) l2 = l2.next;
            }
            if(res == null){
                res = temp;
            } else{
                prev.next = temp;
            }
            prev = temp;
        }
        // end of loop, one of the linked list is null, append the other one to res
        if(l1 == null){
            prev.next = l2;
        }
        if(l2 == null){
            prev.next = l1;
        }
        return res;
    }
}
