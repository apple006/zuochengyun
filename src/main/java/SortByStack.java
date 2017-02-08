import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/8.
 *
 * 使用一个栈倒序另一个栈
 */
public class SortByStack {
    private Stack<Integer> stack;

    public SortByStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void sortByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            while(!help.isEmpty() && help.peek() < temp) {
                stack.push(help.pop());
            }
            help.push(temp);
        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }

    }
}
