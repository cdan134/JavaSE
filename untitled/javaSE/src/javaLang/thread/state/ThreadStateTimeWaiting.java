package javaLang.thread.state;

/**
 * @author ChenDan
 * @create 2021-04-14
 * @desc
 * * 4.State.TIMED_WAITING：超时等待
 * * 5.State.TERMINATED：终止
 */
public class ThreadStateTimeWaiting {
    public static void main(String[] args) {
        Object obj = new Object();
        synchronized (obj){
            try {
                obj.wait(100);  // 等待
//                obj.wait(100*900);  // 超时等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
