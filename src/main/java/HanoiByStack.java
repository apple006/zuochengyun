import javax.swing.*;
import java.util.Stack;

/**
 * Created by dengdechao on 2017/2/13.
 *
 *
 * 用栈实现汉诺塔
 */
public class HanoiByStack {

    enum Action {
        No
       ,MToL
       ,LToM
       ,MToR
       ,RToM
    }


    public int fStackTotStack(Stack<Integer> fStack, Stack<Integer> tStack, String from, String to, Action[] record, Action preNoAct, Action nowAct) {

        if(record[0] != preNoAct && fStack.peek() > tStack.peek()) {
            tStack.push(fStack.peek());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            preNoAct = nowAct;
            return 1;
        }

        return 0;
    }

    public int hanoi(int num, String from, String mid, String to) {
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> midStack = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();

        Action[] record = {Action.No};

        int step = 0;

        for(int i = num; i > 0; --i) {
            leftStack.push(i);
        }

        while(rightStack.size() != num + 1) {
            step += fStackTotStack(leftStack,midStack,"left","mid",record,Action.MToL, Action.LToM);
            step += fStackTotStack(midStack,rightStack,"mid","right",record,Action.RToM,Action.MToR);
            step += fStackTotStack(rightStack,midStack,"right","mid",record,Action.MToR,Action.RToM);
            step += fStackTotStack(midStack,leftStack,"mid","left",record,Action.LToM,Action.MToL);
        }

        return step;
    }
}
