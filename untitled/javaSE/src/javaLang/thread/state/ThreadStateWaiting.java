package javaLang.thread.state;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc 3.State.WAITING：等待
 * *      Thread.join():对应线程休眠
 * *      Thread.yield()：对应线程释放CPU  两个窗口分别售票售票，买一张就停
 */
public class ThreadStateWaiting {
    public static void main(String[] args) {
        ThreadStateWaitingTest tswt1 = new ThreadStateWaitingTest();
        ThreadStateWaitingTest tswt2 = new ThreadStateWaitingTest();

        tswt1.setName("线程1");
        tswt2.setName("线程2");

        tswt1.start();

        try {
            tswt1.join();  // 等tswt1线程结束之后才可以运行下面的语句
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tswt2.start();  // tswt2相当于没有运行
        System.out.println("线程结束！");

    }
}

class ThreadStateWaitingTest extends Thread {
    static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket--);
                    Thread.yield();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

}
