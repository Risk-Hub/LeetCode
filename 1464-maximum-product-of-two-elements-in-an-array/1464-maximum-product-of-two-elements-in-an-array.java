class Solution {
    public int maxProduct(int[] nums) {
        for(int i = 1;i < nums.length;i++){
            int j = i - 1;
            int key = nums[i];
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}