/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Remove consecutive head nodes that should be removed
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        // Now head is either null or the first node not having val
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Remove the next node
            } else {
                curr = curr.next; // Move forward only when no removal
            }
        }
        
        return head;
    }
}