class FrontMiddleBackQueue {
    ListNode head;
    public FrontMiddleBackQueue() {
        head = null;
    }
    
    public void pushFront(int val) {
        if(head == null){
            head = new ListNode(val);
        }
        else {
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
        }
    }

    public void pushMiddle(int val) {
        if(head == null){
            head = new ListNode(val);
        }
        else {
            int size = 0;
            ListNode curr = head;
            while (curr != null){
                size++;
                curr = curr.next;
            }
            int mid = (int)Math.floor(size / 2.0);
            curr = head;
            if(mid > 0){
                int n = 1;
                while (n != mid){
                    curr = curr.next;
                    n++;
                }
                ListNode temp = new ListNode(val);
                temp.next = curr.next;
                curr.next = temp;
            }
            if(mid == 0){
                ListNode temp = new ListNode(val);
                temp.next = curr;
                curr.next = null;
                head = temp;
            }
        }
    }

    public void pushBack(int val) {
        if (head == null){
            head = new ListNode(val);
        }
        else {
            ListNode curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = new ListNode(val);
        }
    }

    public int popFront() {
        if(head == null){
            return -1;
        }
        int val = head.val;
        head = head.next;
        return val;
    }

    public int popMiddle() {
        if(head == null){
            return -1;
        }
        int size = 0;
        ListNode prev = head,curr = head.next;
        while (prev != null){
            size++;
            prev = prev.next;
        }
        int mid;
        if(size % 2 != 0){
            mid = size / 2;
        }
        else {
            mid = (size / 2) - 1;
        }
        prev = head;
        if(mid > 0){
            int n = 0;
            while (n != mid - 1){
                curr = curr.next;
                prev = prev.next;
                n++;
            }
        }
        if(size == 1){
            int val = head.val;
            head = head.next;
            return val;
        }
        int val;
        if(mid == 0){
            val = prev.val;
            head = head.next;
            return val;
        }
        val = curr.val;
        prev.next = curr.next;
        return val;
    }

    public int popBack() {
        if(head == null){
            return -1;
        }
        ListNode curr = head.next,prev = head;
        if(curr == null){
            head = head.next;
            return prev.val;
        }
        while (curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }
        int val = curr.val;
        prev.next = null;
        return val;
    }
}