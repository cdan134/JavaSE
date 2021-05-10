package temp;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc ReentrantLock
 */

class Lock implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Lock l1 = new Lock();

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l1);
        Thread t3 = new Thread(l1);

        t1.start();
        t2.start();
        t3.start();
    }
}
