class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            divide(ints, 0, ints.length - 1);
        }
        int ans = 0;
        for(int i = grid[0].length - 1;i >= 0;i--){
            int temp = grid[0][i];
            for(int j = 1;j < grid.length;j++){
                temp = Math.max(grid[j][i],temp);
            }
            ans += temp;
        }
        return ans;
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
        int mid = (left + right) / 2;
        int[] temp = new int[right - left + 1];
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
        for (int i = left,pos = 0;pos < k;i++,pos++){
            arr[i] = temp[pos];
        }
    }
}