package javaLang.thread.method;

import static java.lang.Thread.sleep;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc  线程方法
 * void	start()	用于启动线程的执行。
 * void	run()	用于对线程执行操作。
 * static void	sleep()	使线程休眠指定的时间。
 * static Thread	currentThread()	返回对当前正在执行的线程对象的引用。
 * void	join()	等待线程死亡/先执行多长时间
 * int	getPriority()	返回线程的优先级。
 * void	setPriority()	更改线程的优先级。
 * String	getName()	返回线程的名称。
 * void	setName()	更改线程的名称。
 * long	getId()	返回线程的ID。
 * boolean	isAlive()	判断线程是否还活着。
 * static void	yield()	使当前正在执行的线程对象暂停，并允许其他线程临时执行。
 * 已不用 void	suspend()	用于挂起线程。
 * 已不用 void	resume()	用于恢复挂起的线程。
 * 已不用 void	stop()	用于停止线程。
 * 已不用 void	destroy()	用于销毁线程组及其所有子组。
 * boolean	isDaemon()	判断线程是否是守护线程。
 * void	setDaemon()	将线程标记为守护程序或用户线程   唯一目的是为后台线程提供服务给用户线程
 * void	interrupt()	中断线程。
 * boolean	isinterrupted()	判断线程是否已被中断。
 * static boolean	interrupted()	判断当前线程是否已被中断。
 * static int	activeCount()	返回当前线程的线程组中活动线程的数量。
 * ？？void	checkAccess()	确定当前正在运行的线程是否有权修改该线程。
 * static boolean	holdLock()	当且仅当当前线程在指定对象上持有监视器锁时，它才返回true。
 * static void	dumpStack()	用于将当前线程的堆栈跟踪信息打印到标准错误流。
 * StackTraceElement[]	getStackTrace()	返回一个表示线程堆栈转储的堆栈跟踪元素数组。
 * ？？static int	enumerate()	用于将每个活动线程的线程组及其子组复制到指定的数组中。
 * Thread.State	getState()	用于返回线程的状态。
 * ThreadGroup	getThreadGroup()	用于返回该线程所属的线程组。
 * String	toString()	用于返回此线程的字符串表示形式，包括线程的名称，优先级和线程组。
 * void	notify()	仅用于通知正在等待特定对象的一个​​线程。
 * void	notifyAll()	用于向特定对象的所有等待线程发出通知。
 * ？？void	setContextClassLoader()	为线程设置上下文ClassLoader。
 * ？？ClassLoader	getContextClassLoader()	返回线程的上下文ClassLoader。
 * ？？static Thread.UncaughtExceptionHandler	getDefaultUncaughtExceptionHandler()	返回由于未捕获的异常导致线程突然终止时调用的默认处理程序。
 * ？？static void	setDefaultUncaughtExceptionHandler()        	设置当线程由于未捕获的异常突然终止时调用的默认处理程序。
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        Thread.currentThread().checkAccess();
        System.out.println();
//        Thread.currentThread().getThreadGroup().list();

        ThreadMethod tm = new ThreadMethod();
        Thread t1 = new Thread(tm);
        Thread t2 = new Thread(tm);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.setPriority(2);
        t2.setPriority(10);

        t1.start();
        try {
            t1.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.interrupt();

        System.out.println(t1.isInterrupted());
//        System.out.println(t1.getPriority());
//        System.out.println(t1.getId());
//        System.out.println(t1.isAlive());
//        System.out.println(t1.isDaemon());
    }
}

class ThreadMethod implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            Thread.yield();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
