import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/6.
 *
 *
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class MyStack1 {
    private Stack<Integer> stackDate;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackDate = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getMin() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("stackMin is empty");
        }
        return this.stackMin.peek();
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (this.getMin() >= newNum) {
            stackMin.push(newNum);
        }
        stackDate.push(newNum);
    }

    public int pop() {
        if(stackDate.isEmpty()) {
            throw new RuntimeException("stackDate is empty");
        }
        int value = stackDate.pop();
        if(value == this.getMin()) {
            stackMin.pop();
        }

        return value;
    }

    public int peek() {
        if(stackDate.isEmpty()) {
            throw new RuntimeException("stackDate is empty");
        }

        return stackDate.peek();
    }

    public boolean isEmpty() {
        if(stackDate.isEmpty()) {
            return true;
        }

        return false;
    }
}
