package javaLang.thread.constructor;

/**
 * @param group     线程组，现在还不知道干啥用
 *                  the thread group. If {@code null} and there is a security
 *                  manager, the group is determined by {@linkplain
 *                  SecurityManager#getThreadGroup SecurityManager.getThreadGroup()}.
 *                  If there is not a security manager or {@code
 *                  SecurityManager.getThreadGroup()} returns {@code null}, the group
 *                  is set to the current thread's thread group.
 * @param target    逻辑执行单元部分,如果Thread类中没有重写run方法，就执行从接口继承的中重写run方法
 *                  the object whose {@code run} method is invoked when this thread
 *                  is started. If {@code null}, this thread's run method is invoked.
 * @param name      线程名称
 *                  the name of the new thread
 * @param stackSize 栈内存的地址空间字节数组，越大栈内存越大
 *                  the desired stack size for the new thread, or zero to indicate
 *                  that this parameter is to be ignored.
 * @author ChenDan
 * @create 2021-04-13
 * @desc Thread类的构造函数的说明
 * <p>
 * Thread(ThreadGroup group,Runnable target,String name,long stackSize);
 */
public class ThreadConstructorsTest {
    public static void main(String[] args) {
        String[] str = {"线程1", "线程2", "线程3", "线程4", "线程5"};
        ThreadGroup tg = new ThreadGroup("线程组");

        Thread t1 = new Thread(tg, new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < str.length; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + str[i]);
                }
            }
        }, str[0], 100) {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        };

        System.out.println(t1.getName());
        System.out.println(t1.getThreadGroup());
        System.out.println(t1.getStackTrace());
        t1.start();  // 因为继承类中重写了run方法，所以最终执行的是重写的最新run方法
    }
}

