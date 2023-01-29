class ListNode {
     int key,val;
     ListNode next,back;
     ListNode() {}
     ListNode(int key,int val) { this.key = key; this.val = val; }
     ListNode(int key, int val, ListNode next, ListNode back) {
         this.key = key;
         this.val = val;
         this.next = next;
         this.back = back;
     }
}

class LRUCache {
    int size = 0,n = 0;
    ListNode head,tail;
    Map<Integer,ListNode> map;
    public LRUCache(int capacity) {
        size = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(head == null || !map.containsKey(key)){
            return -1;
        }
        if(head.key == key){
            return map.get(key).val;
        }
        ListNode curr = map.get(key);
        if(curr == null){
            return -1;
        }
        else if(curr == tail){
            tail = tail.back;
            tail.next = curr.next;
        }
        else {
            curr.back.next = curr.next;
            curr.next.back = curr.back;
        }
        curr.next = head;
        head.back = curr;
        curr.back = null;
        head = curr;
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(head == null){
            head = new ListNode(key,value);
            tail = head;
            map.put(key,head);
            n++;
            return;
        }
        if(map.containsKey(key)){
            ListNode curr = map.get(key);
            if(curr == head){
                head.val = value;
                return;
            }
            else if(curr == tail){
                tail = tail.back;
                tail.next = curr.next;
            }
            else {
                curr.back.next = curr.next;
                curr.next.back = curr.back;
            }
            curr.val = value;
            curr.next = head;
            head.back = curr;
            curr.back = null;
            head = curr;
        }
        else {
            ListNode temp = new ListNode(key,value,head,null);
            map.put(key,temp);
            head.back = temp;
            head = temp;
            if(n < size){
                n++;
            }
            else {
                map.remove(tail.key);
                temp = tail;
                tail = tail.back;
                tail.next = null;
                temp.back = null;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */