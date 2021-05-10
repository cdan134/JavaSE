package javaLang.thread.exception;

/**
 * @author ChenDan
 * @create 2021-04-15
 * @desc IllegalThreadStateException
 *  一个线程启动两次
 *  将用户线程设置为守护程序，但是不启动它(所以在设置之前该线程不能启动)
 */
public class IllegalThreadStateExceptionTest {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();

        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);

        t1.start();
        t1.setDaemon(true);

        t2.start();
//        t2.start();
    }
}

class ThreadTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

        }
    }
}
