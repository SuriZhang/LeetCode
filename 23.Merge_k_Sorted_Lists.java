/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for(int i = 0; i < lists.length; ++i) {
            if(lists[i] != null) queue.offer(lists[i]);
        }
        if(queue.isEmpty()) return null;
        
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if(temp.next != null) queue.offer(temp.next);
            node.next = temp;
            node = node.next;
        }
        return head.next;
    }
}
