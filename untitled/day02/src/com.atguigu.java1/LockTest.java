package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc
 */
class window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            while(true){
                lock.lock();
                if(ticket>0) {
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        window w = new window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
