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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int max = 0;
        ListNode temp = head,dummy = new ListNode(0),curr = dummy;
        while (temp != null){
            if(max <= temp.val){
                max = temp.val;
                curr.next = new ListNode(max);
                curr = curr.next;
            }
            temp = temp.next;
        }
        return reverse(dummy.next);
    }
    ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode prev = head;
            head = head.next;
            prev.next = null;
            head.next = prev;
            return head;
        }
        ListNode prev = head,curr = head.next,aage = head.next.next;
        prev.next = null;
        while (aage != null){
            curr.next = prev;
            prev = curr;
            curr = aage;
            aage = aage.next;
        }
        curr.next = prev;
        return curr;
    }
}