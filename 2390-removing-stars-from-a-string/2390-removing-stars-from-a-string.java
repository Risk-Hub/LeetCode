class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != '*'){
                stack.push(s.charAt(i));
            }
            else {
                stack.pop();
            }
        }
        String temp = "";
        while(!stack.isEmpty()){
            temp += stack.pop();
        }
        s = "";
        for(int i = temp.length() - 1;i >= 0;i--){
            s += temp.charAt(i);
        }
        return s;
    }
}