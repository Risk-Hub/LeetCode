class ListNode{
    char value;
    ListNode next,prev;
    ListNode(char value){
        this.value = value;
    }
}
class Solution {
    public int minTimeToType(String word) {
        ListNode head = null,curr = null;
        for (char i = 'a';i <= 'z';i++){
            if(head == null){
                head = new ListNode(i);
                curr = head;
            }
            else {
                ListNode newNode = new ListNode(i);
                newNode.prev = curr;
                curr.next = newNode;
                curr = curr.next;
            }
        }
        curr.next = head;
        head.prev = curr;
        curr = head;
        int steps = 0,stepCounter,writeCounter = 0;
        for(int i = 0;i < word.length();i++){
            if(curr.value == word.charAt(i)){
                stepCounter = 0;
                writeCounter++;
            }
            else {
                ListNode temp = curr;
                int stepsTemp1 = 0,stepsTemp2 = 0;
                while(temp.value != word.charAt(i)){
                    temp = temp.next;
                    stepsTemp1++;
                }
                temp = curr;
                while (temp.value != word.charAt(i)){
                    temp = temp.prev;
                    stepsTemp2++;
                }
                stepCounter = Math.min(stepsTemp1,stepsTemp2);
                writeCounter += stepCounter + 1;
                curr = temp;
            }
        }
        return writeCounter;
    }
}