class StockSpanner {
    Stack<int[]> stack;
    int count = 0;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price){
            stack.pop();
        }
        if(stack.isEmpty()){
            stack.push(new int[]{count,price});
            count++;
            return count;
        }
        int ans = count - stack.peek()[0];
        stack.push(new int[]{count,price});
        count++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */