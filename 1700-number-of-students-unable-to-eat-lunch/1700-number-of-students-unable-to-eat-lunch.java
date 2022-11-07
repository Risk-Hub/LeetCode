class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = sandwiches.length - 1;i >= 0;i--){
            stack.push(sandwiches[i]);
        }
        for(int i = students.length - 1;i >= 0;i--){
            queue.add(students[i]);
        }
        int i = 0;
        while (!stack.isEmpty()){
            if(queue.peek() == stack.peek()){
                queue.poll();
                stack.pop();
                i = 0;
            }
            else {
                queue.add(queue.poll());
                i++;
            }
            if(i == queue.size()){
                break;
            }
        }
        return queue.size();
    }
}