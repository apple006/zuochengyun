import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/7/11.
 */
public class ThreadPractice {
//    public static void main(String[] args) {
//        FutureTask<Integer> f = new FutureTask<Integer>(()->{
//            int i = 0;
//            for(; i < 100; ++i) {
//                System.out.println(Thread.currentThread().getName() + " " + i);
//            }
//
//            return i;
//        });
//
//        for(int i = 0; i < 100; ++i) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if(i == 20) {
//                Thread t = new Thread(f,"有返回值的线程");
//                t.start();
//                System.out.println(t.isAlive());
//                try {
//                    Thread.sleep(1);
//                    System.out.println("子线程的返回值:" + f.get());
//                    if(!t.isAlive()) {
//                        t.start();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        try {
//            System.out.println("子线程的返回值:" + f.get());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (IllegalThreadStateException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) throws InterruptedException {



        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            int i = 0;
            for(; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " "+Thread.currentThread().getPriority() + " "+ i);
                if(i == 20) {
                    Thread.currentThread().sleep(1);
//                    Thread.yield();
                }
            }
            return i;
        });

        FutureTask<Integer> task2 = new FutureTask<Integer>(()->{
            int i = 0;
            for(; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });

        Thread t = new Thread(task, "一号线程");
//        t.setDaemon(true);
//        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        Thread.currentThread().setPriority(6);

        for(int i = 0; i < 100; ++i) {
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + " " +Thread.currentThread().getPriority() + " "+ i);
//            if(i == 20) {
//                Thread t2 = new Thread(task2,"二号线程");
//                t2.start();
//                try {
//                    t2.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
