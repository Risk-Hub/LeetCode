class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length - 1);
        return nums;
    }
    void divide(int[] arr,int left,int right){
        if(left < right){
            int mid = (left + right) / 2;
            divide(arr,left,mid);
            divide(arr,mid + 1,right);
            conquer(arr,left,right);
        }
    }
    void conquer(int[] arr,int left,int right){
        int[] temp = new int[right - left + 1];
        int mid = (left + right) / 2;
        int idx1 = left,idx2 = mid + 1,k = 0;
        while (idx1 <= mid && idx2 <= right){
            if(arr[idx1] < arr[idx2]){
                temp[k++] = arr[idx1++];
            }
            else {
                temp[k++] = arr[idx2++];
            }
        }
        while (idx1 <= mid){
            temp[k++] = arr[idx1++];
        }
        while (idx2 <= right){
            temp[k++] = arr[idx2++];
        }
        for (int i = left,j = 0;j < k;i++,j++){
            arr[i] = temp[j];
        }
    }
}