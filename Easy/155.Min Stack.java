public class MinStack {
    private Stack<Integer> mStack;
    private Stack<Integer> mMinStack;


    /** initialize your data structure here. */
    public MinStack() {
        this.mStack = new Stack<Integer>();
        this.mMinStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        mStack.push(x);
        if (mMinStack.size() != 0) {
            int min = mMinStack.peek();
            if (x <= min) {
                mMinStack.push(x);
            } 
        } else {
            mMinStack.push(x);
        }
    }
    
    public void pop() {
        int x = mStack.pop();
        if (mMinStack.size() != 0) {
            if (x == mMinStack.peek()) {
                mMinStack.pop();
            }
        }
    }
    
    public int top() {
        return mStack.peek();
    }
    
    public int getMin() {
        return mMinStack.peek();
    }
}