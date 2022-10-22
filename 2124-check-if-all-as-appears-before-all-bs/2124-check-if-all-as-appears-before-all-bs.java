class Solution {
    public boolean checkString(String s) {
        char ch = 'a';
        for (int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'b'){
                ch = 'b';
            }
            if(s.charAt(i) == 'a' && ch == 'b'){
                return false;
            }
        }
        return true;
    }
}