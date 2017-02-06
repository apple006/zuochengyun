import org.junit.Test;

/**
 * Created by dengdechao on 2017/2/6.
 */
public class TestMyStack1 {

    private MyStack2 stack = new MyStack2();

    @Test
    public void testPushAndPop() throws Exception {
        for(int i = 10; i >= 0; --i) {
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.getMin());
            System.out.println(stack.pop());
        }

    }
}
