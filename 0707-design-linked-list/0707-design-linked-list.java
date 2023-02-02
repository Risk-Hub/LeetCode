class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
}

class MyLinkedList {
    ListNode head;
    int size = 0;
    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        int n = 0;
        ListNode curr = head;
        while (n != index && curr != null){
            curr = curr.next;
            n++;
        }
        return curr == null ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        if(head == null){
            head = new ListNode(val);
        }
        else {
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void addAtTail(int val) {
        if(head == null){
            head = new ListNode(val);
        }
        else {
            ListNode curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = new ListNode(val);
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
        }
        else if(index < size){
            ListNode curr = head;
            int n = 0;
            while (n < index - 1){
                curr = curr.next;
                n++;
            }
            ListNode temp = new ListNode(val);
            temp.next = curr.next;
            curr.next = temp;
            size++;
        }
        else if(index == size){
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        if(head != null && index == 0){
            head = head.next;
            size--;
        }
        else if(head != null && index < size){
            ListNode curr = head.next,prev = head;
            int n = 0;
            while (n < index - 1){
                prev = prev.next;
                curr = curr.next;
                n++;
            }
            if(curr.next == null){
                prev.next = null;
            }
            else {
                prev.next = curr.next;
                curr.next = null;
            }
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */