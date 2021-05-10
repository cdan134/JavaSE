package com.atguigu.java1;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc
 * A线程：b对象的bar方法（将B锁住执行输出两行+将A锁住执行A对象的last方法）
 * B线程：a对象的foo方法（将A锁住执行输出一行+将B锁住执行B对象的foo方法）
 */

class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了A实例模式的foo方法");
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用B实例的last方法");
        b.last();
    }

    public synchronized void last() {
        System.out.println("进入了A类的last方法内部");
    }
}

class B {
    public synchronized void bar(A a) { //将B锁住
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了B实例模式的bar方法");
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用A实例的last方法");
        a.last();
    }

    public synchronized void last() {
        System.out.println("进入了B类的last方法内部");
    }
}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();
    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了主线程之后");
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
//        new Thread(dl).start();
        dl.init();
    }
}
