class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int temp = num,i = 0;
        while (temp > 0){
            arr[i++] = temp % 10;
            temp /= 10;
        }
        sortArray(arr);
        int num1 = (arr[0] * 10) + arr[2];
        int num2 = (arr[0] * 10) + arr[3];
        int num3 = (arr[1] * 10) + arr[2];
        int num4 = (arr[1] * 10) + arr[3];
        return Math.min(num1 + num4,num2 + num3);
    }
    public void sortArray(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}