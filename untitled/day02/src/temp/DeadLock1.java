package temp;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc 虚类死锁
 */
public class DeadLock1 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (sb1) {
                    sb1.append("a");
                    sb2.append("1");
                    System.out.println("*1:" + sb1);
                    System.out.println("*1:" + sb2);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (sb2) {
                        sb1.append("b");
                        sb2.append("2");
                        System.out.println("**1:" + sb1);
                        System.out.println("**1:" + sb2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (sb2){
                   sb1.append("c");
                   sb2.append("3");
                   System.out.println("*2:" + sb1);
                   System.out.println("*2:" + sb2);

                   synchronized (sb2) {
                       sb1.append("d");
                       sb2.append("4");
                       System.out.println("**2:" + sb1);
                       System.out.println("**2:" + sb2);
                   }
               }
            }
        }).start();

    }

}
