class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0,n = strs.length,m = strs[0].length();
        Set<Integer> set = new HashSet<>();
        char[] arr = strs[0].toCharArray();
        for(int i = 1;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!set.contains(j)){
                    if(arr[j] > strs[i].charAt(j)){
                        ans++;
                        set.add(j);
                    }
                }
            }
            arr = strs[i].toCharArray();
        }
        return ans;
    }
}