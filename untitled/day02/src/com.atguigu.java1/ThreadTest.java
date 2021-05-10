package com.atguigu.java1;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc 死锁：不同的线程分别占用对象需要的同步资源不放弃 S1要S2 PK 有S2要S1
 * 死锁：不抛异常，不提示错误，只会出现线程阻塞的情况
 */
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    System.out.println("*1:" + s1);
                    System.out.println("*1:" + s2);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println("*1:" + s1);
                        System.out.println("*1:" + s2);
                    }
                }
                System.out.println("*1:" + s1);
                System.out.println("*1:" + s2);

            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    System.out.println("*2:" + s1);
                    System.out.println("*2:" + s2);

                    synchronized (s2){
                        s1.append("d");
                        s2.append("4");
                        System.out.println("*2:" + s1);
                        System.out.println("*2:" + s2);
                    }
                }
                System.out.println("*2:" + s1);
                System.out.println("*2:" + s2);
            }
        }).start();

    }
}
