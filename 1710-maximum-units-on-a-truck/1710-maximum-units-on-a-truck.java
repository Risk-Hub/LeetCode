class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        for(int i = 1;i < boxTypes.length;i++){
            int j = i - 1;
            int key1 = boxTypes[i][1],key2 = boxTypes[i][0];
            while (j >= 0 && key1 > boxTypes[j][1]){
                boxTypes[j + 1][1] = boxTypes[j][1];
                boxTypes[j + 1][0] = boxTypes[j][0];
                j--;
            }
            boxTypes[j + 1][1] = key1;
            boxTypes[j + 1][0] = key2;
        }
        int ans = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                ans += boxType[1] * boxType[0];
                truckSize -= boxType[0];
            } else {
                while (truckSize != 0) {
                    ans += boxType[1];
                    truckSize--;
                }
            }
        }
        return ans;
    }
}