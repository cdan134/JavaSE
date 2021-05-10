package javaLang.thread.constructor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ChenDan
 * @create 2021-04-13
 * @desc java.lang.Thread类的使用, 1-100数值由两个线程输出
 * <p>
 * Thread类的应用方式
 * class PrimeThread extends Thread {
 * long minPrime;
 * PrimeThread(long minPrime) {
 * this.minPrime = minPrime;
 * }
 * <p>
 * public void run() {
 * // compute primes larger than minPrime
 * &nbsp;.&nbsp;.&nbsp;.
 * }
 * }
 * <p>
 * PrimeThread p = new PrimeThread(143);
 * p.start();
 * <p>
 * Runnable接口的应用方式
 * class PrimeRun implements Runnable {
 * long minPrime;
 * PrimeRun(long minPrime) {
 * this.minPrime = minPrime;
 * }
 * <p>
 * public void run() {
 * // compute primes larger than minPrime
 * &nbsp;.&nbsp;.&nbsp;.
 * }
 * }
 * <p>
 * PrimeRun p = new PrimeRun(143);
 * new Thread(p).start();
 * <p>
 * 优点：实现多核同时运行
 * 缺点：可能出现同线程输出同值的问题
 * 解决方式：使用同步锁的方式
 *
 * 接口Callable，有返回值，抛出异常，重写call()方法，放入FutureTask构造器中，创建线程start调用
 */

public class ThreadClassTest {
    public static void main(String[] args) {
        Thread3 t3 = new Thread3();
        FutureTask futureTask = new FutureTask(t3);
        new Thread(futureTask).start();

        Object sum = null;
        try {
            sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        Thread1 t1 = new Thread1();
//        Thread1 t2 = new Thread1();
//        t1.setName("线程1");
//        t2.setName("线程2");
//        t1.start();
//        t2.start();
//
//        Thread2 r2 = new Thread2();
//        Thread th1 = new Thread(r2);
//        Thread th2 = new Thread(r2);
//        th1.setName("线程3");
//        th2.setName("线程4");
//        th1.start();
//        th2.start();
    }
}

class Thread1 extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + ticket);
                ticket--;
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

class Thread2 implements Runnable {
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + ticket);
                ticket--;
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}

class Thread3 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
