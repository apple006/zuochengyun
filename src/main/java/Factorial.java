/**
 * Created by dengdechao on 2017/2/7.
 *
 *
 * 菲波那切数列
 */
public class Factorial {

    public int math(int n) {
        if(n == 0) {
            return 1;
        } else {
            int i = math(n - 1);
            return n * i;
        }
    }

    public static void main(String[] args) {
        int x=6,y=8;
        boolean b;
        b=x<y || ++x==--y;
        System.out.println(b);
        System.out.println(x);
        System.out.println(y);
    }
}
