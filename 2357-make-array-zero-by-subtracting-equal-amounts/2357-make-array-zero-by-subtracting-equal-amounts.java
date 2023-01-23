class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            int diff = nums[i];
            for(int j = i;j < nums.length;j++){
                nums[j] -= diff;
            }
            ans++;
            if(Arrays.equals(nums,temp)) {
                return ans;
            }
        }
        return ans;
    }
}