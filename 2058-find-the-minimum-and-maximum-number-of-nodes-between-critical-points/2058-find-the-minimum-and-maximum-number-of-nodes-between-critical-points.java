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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        if(size <= 3){
            return new int[]{-1,-1};
        }
        ListNode prev = head,aage = head.next.next;
        curr = head.next;
        int count = 2;
        List<Integer> list = new ArrayList<>();
        while (aage != null){
            if((prev.val < curr.val && curr.val > aage.val) || (prev.val > curr.val && curr.val < aage.val)){
                list.add(count);
            }
            count++;
            prev = prev.next;
            curr = curr.next;
            aage = aage.next;
        }
        if(list.size() < 2){
            return new int[]{-1,-1};
        }
        int maxElem = list.get(0),minElem = list.get(0);
        int maxDiff = Integer.MIN_VALUE,minDiff = Integer.MAX_VALUE;
        for (int i = 1;i < list.size();i++){
            maxDiff = Math.max(maxDiff,Math.abs(list.get(i) - minElem));
            minElem = Math.min(minElem,list.get(i));
            minDiff = Math.min(minDiff,Math.abs(list.get(i) - maxElem));
            maxElem = Math.max(maxElem,list.get(i));
        }
        return new int[]{minDiff,maxDiff};
    }
}