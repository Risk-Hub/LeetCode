class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        System.out.println(stack.isEmpty());
        String str = "";
        while (!stack.isEmpty()){
            str += stack.pop();
        }
        return str;
    }
}