class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0 ;
        for(int i = 0;i < arr.length;i++){
            ans += arr[i] * Math.ceil((arr.length - i) * (i + 1) / 2.0);
        }
        return ans;
    }
}