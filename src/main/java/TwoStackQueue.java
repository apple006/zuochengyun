import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/6.
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            while(!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();

    }

    public int peek() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            while(!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }
}
