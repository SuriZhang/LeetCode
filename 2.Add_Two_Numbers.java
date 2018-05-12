/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l1.next == null){
            return l2;
        }
        if(l2.val == 0 && l2.next == null){
            return l1;
        }
        ListNode prev = null;
        ListNode res = null;
        ListNode temp = null;
        int carry = 0;
        int sum;
        while(l1 != null || l2 != null){ // l1, l2 can be of diff len, so use OR, cannot use AND
            if(l1 == null){
                sum = carry + l2.val;
            } else if (l2 == null){
                sum = carry + l1.val; 
            } else {
                sum = carry + l1.val + l2.val;
            }
            if(sum >= 10){ // if sum > 10, set carry = 1, reduce sum to single digit
                carry = 1;
                sum %= 10;
            } else{ // else reset carry = 0
                carry = 0;
            }
            temp = new ListNode(sum);
            if(res == null){ // res is empty
                res = temp;
            } else{ // res is not empty, insert after 
                prev.next = temp;
            }
            prev = temp;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        // if there is a carried over leading 1
        if(carry != 0) temp.next = new ListNode(carry);
        return res;
    }
}
