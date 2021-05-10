package javaLang.thread.state;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc  RUNNABLE
 * 1.State.RUNNABLE：就绪/运行
 *      Thread.start()
 */
public class ThreadStateRunnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getState());
    }
}
