class Solution {
    public int maxIceCream(int[] costs, int coins) {
        divide(costs,0,costs.length - 1);
        int ans = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                ans++;
                coins -= cost;
            }
            else {
                break;
            }
        }
        return ans;
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int[] mergedArr = new int[right - left + 1];
        int idx1 = left,idx2 = mid+1,x = 0;
        while (idx1 <= mid && idx2 <= right){
            if(arr[idx1] <= arr[idx2]){
                mergedArr[x] = arr[idx1];
                x++;
                idx1++;
            }
            else {
                mergedArr[x] = arr[idx2];
                x++;
                idx2++;
            }
        }
        while (idx1 <= mid){
            mergedArr[x] = arr[idx1];
            x++;
            idx1++;
        }
        while (idx2 <= right){
            mergedArr[x] = arr[idx2];
            x++;
            idx2++;
        }
        for (int i = 0,j = left;i < mergedArr.length;i++,j++){
            arr[j] = mergedArr[i];
        }
    }
    public static void divide(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int mid = (left + right)/2;
        divide(arr,left,mid);
        divide(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
}