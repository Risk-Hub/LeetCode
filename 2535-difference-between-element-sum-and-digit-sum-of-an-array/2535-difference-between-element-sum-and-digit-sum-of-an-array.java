class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0,digitSum = 0;
        for(int elements: nums){
            elementSum += elements;
            while(elements > 0){
                digitSum += elements % 10;
                elements /= 10;
            }
        }
        return Math.abs(elementSum - digitSum);
    }
}