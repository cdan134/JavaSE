package javaLang.thread.state;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc State.BLOCKED：阻塞
 * *      等待进入到synchronized方法
 * *      Thread.sleep()：对应CPU阻塞
 * *      Object.wait()：对应线程休眠 PK Object.motify()：对应线程唤醒
 */
public class ThreadStateBlock {
    public static void main(String[] args) {
        try {
            Thread.sleep(100);   // Thread.sleep()：对应CPU阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.sleep()");

        ThreadStateBlockTest tsbt1 = new ThreadStateBlockTest();
        ThreadStateBlockTest tsbt2 = new ThreadStateBlockTest();

        tsbt1.setName("线程一");
        tsbt2.setName("线程2");

        tsbt1.start();
        tsbt2.start();
    }
}

class ThreadStateBlockTest extends Thread {
    static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj){  // 等待进入到synchronized方法
                obj.notifyAll();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket--);
                    try {
                        obj.wait();
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


