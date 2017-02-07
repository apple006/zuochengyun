import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/7.
 *
 *
 * 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {
    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    private Stack<Integer> stack;

    public ReverseStack() {
        this.stack = new Stack<Integer>();
    }

    public void push(int i) {
        stack.push(i);
    }

    public int getAndRemoveLastEle(Stack<Integer> stack) {
        int last = stack.pop();
        if(stack.empty()) {
            return last;
        } else {
            int result = getAndRemoveLastEle(stack);
            stack.push(last);
            return result;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if(stack.empty()) {
            return;
        } else {
            int i = getAndRemoveLastEle(stack);
            reverse(stack);
            stack.push(i);
        }
    }

}
