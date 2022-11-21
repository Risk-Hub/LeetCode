class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
        }
        char[] freq = new char[s.length()];
        for(int i = 0;i < s.length();i++){
            freq[map.get(s.charAt(i))]++;
        }
        int pos = -1;
        for(int i = 0;i < s.length();i++){
            if(freq[i] == 1){
                pos = i;
                break;
            }
        }
        return pos;
    }
}