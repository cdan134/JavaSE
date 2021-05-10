package com.atguigu.java2;

/**
 * @author ChenDan
 * @create 2021-04-13
 * @desc 1-100数值，两个线程交替输出 Thread类 Runnable接口
 * wait()、notify()没有特别说明的话就是this对象，如果是不同对象就需要调用对应的对象
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
//        Wait1 w = new Wait1();
//
//        Thread t1 = new Thread(w);
//        Thread t2 = new Thread(w);
//
//        t1.setName("线程A");
//        t2.setName("线程B");
//
//        t1.start();
//        t2.start();

//        Wait2 w1 = new Wait2();
//        Wait2 w2 = new Wait2();
//
//        w1.setName("线程1");
//        w2.setName("线程2");
//
//        w1.start();
//        w2.start();

        int num = 100;

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        notify();
                        if(this.num >0){
                            System.out.println(Thread.currentThread().getName() + " : " + num);
                            this.num--;
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {

            }
        }.start();

    }
}

class Wait2 extends Thread {
    static int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Wait2.class) {
                Wait2.class.notify();
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    num--;
                    try {
                        Wait2.class.wait();
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

class Wait1 implements Runnable {
    static int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    num--;
                    try {
                        wait();
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


