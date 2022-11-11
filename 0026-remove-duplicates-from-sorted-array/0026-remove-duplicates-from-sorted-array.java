class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 1;
        int temp = nums[0];
        int counter = 1;
        boolean flag = false;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] != temp){
                counter++;
                temp = nums[i];
                // if(flag){
                    nums[pos] = nums[i];
                    pos++;
                    flag = false;
                // }
            }
            // else {
            //     flag = true;
            // }
        }
        return pos;
    }
}