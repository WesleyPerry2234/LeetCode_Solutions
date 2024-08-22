/**
 *  https://leetcode.com/problems/min-stack/submissions/1265551506/
 *  submitted at May 23, 2024 00:13
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
    private java.util.Stack<Integer> minVal = new java.util.Stack<Integer>();
    private java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

    public MinStack() {
    }
    
    public void push(int val) {
        if((this.stack.size() == 0) || (val <= this.minVal.peek())) {
            this.minVal.push(val);
        }
        this.stack.push(val);
    }
    
    public void pop() {
        //Comparison doesn't work correctly if not cast to int:
        if(((int)(this.stack.pop())) == this.minVal.peek()) {
            this.minVal.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minVal.peek();
    }
}
/*
    1       2       3       4     5     6       7       8       9       10  11
["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
[[],        [512],[-1024],[-1024],[512], [],   [],      [],   [],      [],   []]

1:
()

2: push 512
stack=512
min=512

3: push -1024
stack=-1024,512
min=-1024,512

4: push -1024
stack=-1024,-1024,512
min=-1024,-1024,512

5: push 512
stack=512,-1024,-1024,512
min=-1024,-1024,512

6: pop
stack=-1024,-1024,512
min=-1024,-1024,512

7: getMin
stack=-1024,-1024,512
min=-1024,-1024,512

8: pop
stack=-1024,512
min=-1024,512

9: getMin
stack=-1024,512
min=-1024,512

10: pop
stack=512
min=512

11: getMin
stack=512
min=512

 */
