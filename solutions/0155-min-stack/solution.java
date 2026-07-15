class MinStack {
    Deque<Integer> stack    = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        
        int curMin = minStack.isEmpty() ? val
                     : Math.min(val, minStack.peek());
        minStack.push(curMin);
    }

    public void pop() {
        stack.pop();
        minStack.pop();  
    }

    public int top()    { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
