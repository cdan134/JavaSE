package temp;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc
 */
public class synchronizedTest1 {
    public static void main(String[] args) {
        synchronized1 s1 = new synchronized1();
        synchronized1 s2 = new synchronized1();
        synchronized1 s3 = new synchronized1();

        s1.setName("窗口1");
        s2.setName("窗口2");
        s3.setName("窗口3");

        s1.start();
        s2.start();
        s3.start();
    }
}

class synchronized1 extends Thread {
    static int num = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            show();
        }
//        while (true) {
//            synchronized (obj) {
////            synchronized (synchronized1.class) {
//                if (num > 0) {
//                    System.out.println(Thread.currentThread().getName() + " : " + num);
//                    num--;
//                } else {
//                    break;
//                }
//            }
//        }
    }

    public static synchronized void show() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + num);
            num--;
        }
    }
}
