class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1){
            return 1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < trust.length;i++) {
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
            set.add(trust[i][0]);
        }
        if(map.containsValue(n - 1)){
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(Objects.equals(n - 1,entry.getValue()) && !set.contains(entry.getKey())){
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}