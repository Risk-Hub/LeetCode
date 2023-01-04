class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for(int freq: map.values()){
            if(freq == 1){
                return -1;
            }
            if (freq % 3 == 1) {
                ans += (freq - 4) / 3;
                ans += 2;
            }
            else {
                if(freq >= 3){
                    ans += freq / 3;
                    freq = freq % 3;
                }
                if(freq == 2){
                    ans++;
                }
            }
        }
        return ans;
    }
}