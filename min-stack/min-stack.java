/**
 *  https://leetcode.com/problems/min-stack/submissions/1265559394/
 *  submitted at May 29, 2024 12:37
**/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
    private e top;

    public MinStack() {
        
    }
    
    public void push(int val) {
        this.top = new e(val,(top == null ? val : (val < top.min ? val : top.min)),top);
    }
    
    public void pop() {
        this.top = top.parent;
    }
    
    public int top() {
        return this.top.val;
    }
    
    public int getMin() {
        return this.top.min;
    }

    private class e {
        public int val;
        public int min;
        public e parent;

        public e(int val, int min, e parent) {
            this.val = val;
            this.min = min;
            this.parent = parent;
        }

    }
}
