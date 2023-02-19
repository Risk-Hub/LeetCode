class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < nums.length;i++){
            while (nums[i] > 0){
                stack.push(nums[i] % 10);
                nums[i] /= 10;
            }
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}