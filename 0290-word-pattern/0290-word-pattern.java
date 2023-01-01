class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        Map<String,Character> map = new HashMap<>();
        for (int i = 0;i < arr.length;i++) {
            if (!map.containsValue(pattern.charAt(i))) {
                map.put(arr[i], pattern.charAt(i));
            }
        }
        String ans = "";
        for (String value : arr) {
            ans += map.get(value);
        }
        return ans.equals(pattern);
    }
}