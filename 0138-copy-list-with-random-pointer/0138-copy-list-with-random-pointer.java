/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(0),curr1 = dummy,curr2 = head;
        Map<Node,Node> map = new HashMap<>();
        while (curr2 != null){
            map.put(curr2,new Node(curr2.val));
            curr2 = curr2.next;
        }
        curr2 = head;
        while(curr2 != null){
            curr1.next = map.get(curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        curr1.next = null;
        curr1 = dummy.next;
        curr2 = head;
        while (curr2 != null){
            map.get(curr2).random = map.get(curr2.random);
            curr2 = curr2.next;
        }
        return dummy.next;
    }
}