class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(0, n - 1, nums, target);
    }
    
    public int binarySearch(int left, int right,int[] nums, int target){
        if(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target < nums[mid]){
                return binarySearch(left, mid - 1, nums, target);
            }
            else{
                return binarySearch(mid + 1, right, nums, target);
            }
        }
        else{
            return -1;
        }
    }
}