package javaLang.thread.state;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc 线程的状态:RUNNABLE/BLOCKED
 * <p>

 *
 * 5.State.TERMINATED：终止
 */
public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadStateTest tst = new ThreadStateTest();
        ThreadState ts = new ThreadState();

        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);

        t1.start();    // 1.RUNNABLE
        t2.start();    // 1.RUNNABLE

        try {
            t1.join(100);  // 3.1线程休眠100sm
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class ThreadState implements Runnable {
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (ticket > 0) {
//            show();

            synchronized (this){
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket--);

                    try {
                        wait();   // 3.2阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    public synchronized void show() {
        notify(); // 3.2唤醒

        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + ticket--);

            try {
                wait();   // 3.2阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
