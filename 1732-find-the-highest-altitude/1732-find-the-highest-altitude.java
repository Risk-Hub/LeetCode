class Solution {
    public int largestAltitude(int[] gain) {
        int[] heights = new int[gain.length + 1];
        for(int i = 0;i < gain.length;i++){
            heights[i + 1] = heights[i] + gain[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int height: heights){
            if(ans < height){
                ans = height;
            }
        }
        return ans;
    }
}