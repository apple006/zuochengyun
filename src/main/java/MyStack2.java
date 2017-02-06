import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/6.
 *
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getMin() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("stackMin is empty");
        }

        return stackMin.peek();
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (this.getMin() >= newNum) {
            stackMin.push(newNum);
        } else {
            int newMin = stackMin.peek();
            stackMin.push(newMin);
        }

        stackData.push(newNum);
    }

    public int pop() {
        if(this.stackData.isEmpty()) {
            throw new RuntimeException("stackData is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int peek() {
        if(stackData.isEmpty()) {
            throw new RuntimeException("stackDate is empty");
        }

        return stackData.peek();
    }

    public boolean isEmpty() {
        if(stackData.isEmpty()) {
            return true;
        }

        return false;
    }
}
