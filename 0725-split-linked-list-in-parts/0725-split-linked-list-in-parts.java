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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        ListNode[] arr = new ListNode[k];
        if(size <= k){
            for (int i = 0;i < size;i++){
                arr[i] = new ListNode(head.val);
                head = head.next;
            }
            for (int i = size; i < k; i++){
                arr[i] = null;
            }
        }
        else {
            int rem = size % k;
            if(rem > 0){
                int[] array = new int[k];
                for(int i = 0;i < k;i++){
                    if(rem > 0){
                        array[i] = (size/k) + 1;
                        rem--;
                    }
                    else {
                        array[i] = size/k;
                    }
                }
                for (int i = 0;i < k;i++){
                    ListNode now = head;
                    int div = array[i];
                    while (div != 1){
                        now = now.next;
                        div--;
                    }
                    arr[i] = head;
                    head = now.next;
                    now.next = null;
                }
            }
            else {
                for (int i = 0;i < k;i++){
                    int div = size / k;
                    ListNode now = head;
                    while (div != 1){
                        now = now.next;
                        div--;
                    }
                    arr[i] = head;
                    head = now.next;
                    now.next = null;
                }
            }
        }
        return arr;
    }
}