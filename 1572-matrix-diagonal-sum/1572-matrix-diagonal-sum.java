class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        for(int i = 0;i < mat.length;i++){
            ans += mat[i][i];
        }
        for(int i = mat.length - 1,j = 0;i >= 0;i--,j++){
            ans += mat[i][j];
        }
        if(mat.length % 2 != 0){
            ans -= mat[mat.length/2][mat.length/2];
        }
        return ans;
    }
}