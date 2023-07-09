class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxm = Integer.MIN_VALUE;
        for(int num : nums){
            if(maxm < num){
                maxm = num;
            }
        }
        int ans = 0;
        for(int i = 0;i < k;i++){
            ans += maxm;
            maxm++;
        }
        return ans;
    }
}