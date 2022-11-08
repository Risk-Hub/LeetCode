class CustomStack {
    int[] stack;
    int counter = 0;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if(counter != stack.length){
            stack[counter++] = x;
        }
    }

    public int pop() {
        if(counter > 0){
            return stack[--counter];
        }
        else {
            return -1;
        }
    }

    public void increment(int k, int val) {
        int i = 0;
        while (i < Math.min(k, stack.length)){
            stack[i++] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */