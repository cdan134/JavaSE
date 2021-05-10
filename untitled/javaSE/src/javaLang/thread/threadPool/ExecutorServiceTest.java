package javaLang.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ChenDan
 * @create 2021-04-15
 * @desc 线程池：ExecutorService，Executors
 * ExecutorService.execute(Thread) 执行创建的线程
 * ExecutorService.shutdown() 关闭线程
 * ExecutorService.isTerminated() 判断线程是否终止
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker); //calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");
        }
    }

class WorkerThread implements Runnable {

    private String message;
    public WorkerThread(String s){
        this.message=s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);
        processmessage();//call processmessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name
    }
    private void processmessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
