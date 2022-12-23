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
    boolean checkCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head,fast = head;
        while (fast != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        if(!checkCycle(head)){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null){
            if(set.contains(curr)){
                return curr;
            }
            else {
                set.add(curr);
                curr = curr.next;
            }
        }
        return null;
    }
}