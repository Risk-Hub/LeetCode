class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 1;
        int temp = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] != temp){
                temp = nums[i];
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
}