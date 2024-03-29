class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < nums[i - 1]){
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] += nums[i - 1] - nums[i] + 1;
            }
            else if(nums[i] == nums[i - 1]){
                ans += 1;
                nums[i]++;
            }
        }
        return ans;
    }
}