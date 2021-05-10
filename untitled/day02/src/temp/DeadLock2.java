package temp;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc 类的对象的死锁
 */


class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程的名称： " + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.funcB();
    }

    public synchronized void funcA() {
        System.out.println("进入A主线程的funA方法");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("当前线程的名称： " + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.funcA();
    }

    public synchronized void funcB() {
        System.out.println("进入B主线程的funB方法");
    }
}

public class DeadLock2 implements Runnable {
    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线城");
        b.bar(a);
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        a.foo(b);
    }

    public static void main(String[] args) {
        DeadLock2 dl = new DeadLock2();
        new Thread(dl).start();
        dl.init();
    }
}