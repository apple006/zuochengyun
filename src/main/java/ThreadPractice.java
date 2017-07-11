import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/7/11.
 */
public class ThreadPractice {
    public static void main(String[] args) {
        FutureTask<Integer> f = new FutureTask<Integer>(()->{
            int i = 0;
            for(; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }

            return i;
        });

        for(int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20) {
                Thread t = new Thread(f,"有返回值的线程");
                t.start();
                System.out.println(t.isAlive());
                try {
                    Thread.sleep(1);
                    System.out.println("子线程的返回值:" + f.get());
                    if(!t.isAlive()) {
                        t.start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            System.out.println("子线程的返回值:" + f.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }
    }
}
