class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1;i >= 0;i--){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && (stack.peek() == (char)(ch+32) || stack.peek() == (char)(ch-32))){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        String ans = "";
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}