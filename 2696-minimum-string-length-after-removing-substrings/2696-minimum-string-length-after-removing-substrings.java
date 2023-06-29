class Solution {
    public int minLength(String s) {
        while (true){
            if(s.contains("AB")){
                String[] arr = s.split("AB");
                s = "";
                for (String value : arr) {
                    s += value;
                }
            }
            else if(s.contains("CD")){
                String[] arr = s.split("CD");
                s = "";
                for (String value : arr) {
                    s += value;
                }
            }
            else{
                break;
            }
        }
        return s.length();
    }
}