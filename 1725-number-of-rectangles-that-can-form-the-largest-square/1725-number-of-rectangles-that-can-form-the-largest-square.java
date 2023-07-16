class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxm = Integer.MIN_VALUE;
        for(int i = 0;i < rectangles.length;i++){
            maxm = Math.max(maxm,Math.min(rectangles[i][0],rectangles[i][1]));
        }
        int ans = 0;
        for(int i = 0;i < rectangles.length;i++){
            if(Math.min(rectangles[i][0],rectangles[i][1]) == maxm){
                ans++;
            }
        }
        return ans;
    }
}