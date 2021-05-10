package javaLangThreadGroup.constructor;

/**
 * @author ChenDan
 * @create 2021-04-15
 * @desc 为了方便线程管理,可以统一设定线程组的一些属性
 * ThreadGroup.getName():   线程组的名称
 * ThreadGroup.getMaxPriority()   线程组的优先级
 * ThreadGroup.activeCount()   线程组的线程数量
 * ThreadGroup.getParent()   线程的父线程
 * ThreadGroup.activeGroupCount()   返回此线程组及其子组中活动组数的估计值
 *
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        printGroupInfo(Thread.currentThread());

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        });
        t.setName("线程1");
        t.start();
        printGroupInfo(t);
    }

    static void printGroupInfo(Thread t){
        ThreadGroup group = t.getThreadGroup();
        ThreadGroup tg1 = new ThreadGroup(group,"线程组1");
//        System.out.println(" thread " + t.getName());
//        System.out.println(" group name is " + group.getName());
//        System.out.println(" max priority is " + group.getMaxPriority());
        System.out.println(" thread count is " + group.activeCount());
        System.out.println(" the number of active groups in this thread group is " + tg1.activeGroupCount());
//        System.out.println(" parent of this thread group is " + group.getParent().getName());
    }

}
