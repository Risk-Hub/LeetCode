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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        int i = 1;
        List<List<Integer>> list1 = new ArrayList<>();
        ListNode curr = head;
        while (curr != null){
            int size = 0;
            List<Integer> list2 = new ArrayList<>();
            while (size != i && curr != null){
                list2.add(curr.val);
                curr = curr.next;
                size++;
            }
            list1.add(list2);
            i++;
        }
        for (int j = 0;j < list1.size();j++){
            if(list1.get(j).size() % 2 == 0){
                int k = 0,l = list1.get(j).size()-1;
                while (k < l){
                    int temp = list1.get(j).get(k);
                    list1.get(j).set(k,list1.get(j).get(l));
                    list1.get(j).set(l,temp);
                    k++;
                    l--;
                }
            }
        }
        ListNode root = null,temp = null;
        for(int j = 0;j < list1.size();j++){
            for(int k = 0;k < list1.get(j).size();k++){
                if(root == null){
                    root = new ListNode(list1.get(j).get(k));
                    temp = root;
                }
                else {
                    temp.next = new ListNode(list1.get(j).get(k));
                    temp = temp.next;
                }
            }
        }
        return root;
    }
}