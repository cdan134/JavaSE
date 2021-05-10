package temp;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc
 */
public class synchronizedTest2 {
    public static void main(String[] args) {
        synchronized2 s1 = new synchronized2();

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class synchronized2 implements Runnable {
    static int num = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
////            synchronized(this) {
////            synchronized(synchronized2.class) {
//            synchronized(obj) {
//                if (num > 0) {
//                    System.out.println(Thread.currentThread().getName() + " : " + num);
//                    num--;
//                } else {
//                    break;
//                }
//            }
        }
    }

    public synchronized void show() {
        if(num>0){
            System.out.println(Thread.currentThread().getName() + " : " + num);
            num--;
        }
    }
}