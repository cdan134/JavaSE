package javaLang.thread.shutdownHook;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc ShutdownHook
 * 当JVM正常或突然关闭时，关闭挂钩可用于执行清理资源或保存状态。
 */
public class ShutdownTest {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        r.addShutdownHook(new MyThread());

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(3000);}catch (Exception e) {}
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("shut down hook task completed..");
    }
}
