class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2){
            return -1;
        }
        int maxm = Integer.MIN_VALUE;
        int minm = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(maxm < nums[i]){
                maxm = nums[i];
            }
            if(minm > nums[i]){
                minm = nums[i];
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != maxm && nums[i] != minm){
                return nums[i];
            }
        }
        return -1;
    }
}