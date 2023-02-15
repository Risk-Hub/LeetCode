class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for(int i = num.length - 1;i >= 0;i--){
            int sum = num[i] + (k % 10) + carry;
            k /= 10;
            stack.push(sum % 10);
            carry = sum / 10;
        }
        while (k > 0){
            int sum = (k % 10) + carry;
            stack.push(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        if(carry == 1){
            list.add(1);
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}