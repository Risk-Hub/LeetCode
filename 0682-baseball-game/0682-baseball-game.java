class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2);
                    stack.push(num1);
                    stack.push(num1 + num2);
                }
                case "D" -> stack.push(2 * stack.peek());
                case "C" -> stack.pop();
                default -> stack.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}