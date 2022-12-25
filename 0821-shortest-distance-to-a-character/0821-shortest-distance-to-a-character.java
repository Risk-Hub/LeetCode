class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int[] arr = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            int ans = Integer.MAX_VALUE;
            for(int j: list){
                ans = Math.min(ans,Math.abs(j - i));
            }
            arr[i] = ans;
        }
        return arr;
    }
}