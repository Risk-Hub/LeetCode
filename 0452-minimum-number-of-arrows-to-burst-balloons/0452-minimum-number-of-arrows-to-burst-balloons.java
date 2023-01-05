class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int temp = points[0][1],ans = 1;
        for(int i = 1;i < points.length;i++){
            if(temp - points[i][0] >= 0){
                continue;
            }
            temp = points[i][1];
            ans++;
        }
        return ans;
    }
}