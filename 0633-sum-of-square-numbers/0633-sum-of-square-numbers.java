class Solution {
    public boolean judgeSquareSum(int c) {
        long right = (long) Math.sqrt(c);
        long left = 0;
        while(left <= right){
            long res = (long)(Math.pow(left,2) + Math.pow(right,2));
            if(res > c){
                right--;
            }
            else if(res < c){
                left++;
            }
            else{
                return true;
            }
            
        }
        return false;
    }
}