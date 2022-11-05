class ListNode {
    String val;
    ListNode next,prev;
    ListNode() {};
    ListNode(String val) { this.val = val; }
    ListNode(String val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev = prev;}
}

class BrowserHistory {
    ListNode browser,curr;
    public BrowserHistory(String homepage) {
        browser = new ListNode(homepage);
        curr = browser;
    }

    public void visit(String url) {
        curr.next = new ListNode(url);
        ListNode temp = curr;
        curr = curr.next;
        curr.prev = temp;
    }

    public String back(int steps) {
        int i = 0;
        while (i != steps && curr.prev != null){
            curr = curr.prev;
            i++;
        }
        return curr.val;
    }

    public String forward(int steps) {
        int i = 0;
        while (i != steps && curr.next != null){
            curr = curr.next;
            i++;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */