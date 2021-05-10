package javaLang.thread.threadGroup;

/**
 * @author ChenDan
 * @create 2021-04-15
 * @desc ThreadGroup 线程组
 * void	checkAccess()	确定当前正在运行的线程是否具有修改线程组的权限。
 * int	activeCount()	返回线程组及其子组中活动线程数的估计值。
 * int	activeGroupCount()	返回线程组及其子组中活动组的数量的估计值。
 * void	destroy()	破坏线程组及其所有子组。
 * int	enumerate(Thread[] list)	将线程组及其子组中的每个活动线程复制到指定的数组中。
 * * int	getMaxPriority()	返回线程组的最大优先级。
 * String	getName()	返回线程组的名称。
 * ThreadGroup	getParent()	返回线程组的父级。
 * void	interrupt()	中断线程组中的所有线程。
 * boolean	isDaemon()	判断线程组是否是守护程序线程组。
 * void	setDaemon(boolean daemon)	更改线程组的守护程序状态。
 * boolean	isDestroyed()	判断此线程组是否已被销毁。
 * * void	list()	将有关线程组的信息打印到标准输出。
 * boolean	parentOf(ThreadGroup g)	判断线程组是线程组参数还是其祖先线程组之一。
 * void	suspend()	用于挂起线程组中的所有线程。
 * void	resume()	用于恢复使用suspend() 方法挂起的线程组中的所有线程。
 * * void	setMaxPriority(int pri)	设置组的最大优先级。
 * void	stop()	用于停止线程组中的所有线程。
 * String	toString()	返回Thread组的字符串表示形式。
 */
public class ThreadGroupTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadGroupTest td = new ThreadGroupTest();
        ThreadGroup tg = new ThreadGroup("线程组1");

        Thread t1 = new Thread(tg, td, "线程1");
        Thread t2 = new Thread(tg, td, "线程2");
        Thread t3 = new Thread(tg, td, "线程3");

        t1.start();
        t2.start();
        t3.start();

        t1.setPriority(7);
        t2.setPriority(1);
        t3.setPriority(6);

//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(tg.getName());
        System.out.println(tg.getMaxPriority());
        System.out.println(tg.getParent().getName());
//        tg.list();
    }

}

