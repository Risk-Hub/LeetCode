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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            curr = curr.next;
            count++;
        }
        int mid = (int) Math.floor(count/2.0);
        if(mid == 0){
            return head.next;
        }
        count = 1;
        ListNode prev = head;
        curr = head.next;
        while (count != mid){
            if (curr != null){
                curr = curr.next;
            }
            prev = prev.next;
            count++;
        }
        prev.next = curr.next;
        return head;
    }
}