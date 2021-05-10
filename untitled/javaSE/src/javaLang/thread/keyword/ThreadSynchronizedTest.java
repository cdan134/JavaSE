package javaLang.thread.keyword;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc 同步锁的测试:同步代码块、同步代码方法
 * 同：都可以作为锁而存在，都是作为关键字
 * 不同：同步代码块是默认锁，继承Thread类是静态锁，Runnble接口是动态锁
 */
public class ThreadSynchronizedTest {
    public static void main(String[] args) {
        ThreadSynchronized1 t1 = new ThreadSynchronized1();
        ThreadSynchronized1 t2 = new ThreadSynchronized1();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

        ThreadSynchronized2 r2 = new ThreadSynchronized2();
        Thread th1 = new Thread(r2);
        Thread th2 = new Thread(r2);
        th1.setName("线程3");
        th2.setName("线程4");
        th1.start();
        th2.start();
    }

}

class ThreadSynchronized1 extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
//            synchronized (ThreadSynchronized1.class) {  // 同步代码块-静态类锁
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + " : " + ticket--);
//                    try {
//                        sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    break;
//                }
//            }

            show();
        }
    }

    public synchronized void show() {  // 同步代码方法-静态类锁
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + ticket--);
        }
    }
}

class ThreadSynchronized2 implements Runnable {
    static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
//            synchronized (this) {  // 同步代码块-动态this对象锁
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
//                    ticket--;
//                    try {
//                        Thread.currentThread().sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    break;
//                }
//            }

            show();
        }
    }

    public synchronized void show() {  // 同步代码方法-动态this对象锁
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + ticket--);
        }
    }
}


