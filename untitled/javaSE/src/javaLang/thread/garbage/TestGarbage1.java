package javaLang.thread.garbage;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc
 * public void finalize()
 *      如果创建了没有new的任何对象，则可以使用finalize方法执行清理处理(销毁剩余对象)
 * gc()
 *      JVM的垃圾收集器仅收集由new关键字创建的对象
 */
public class TestGarbage1 {
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        TestGarbage1 s1 = new TestGarbage1();
        TestGarbage1 s2 = new TestGarbage1();
        s1 = null;
        s2 = null;
        System.gc();

    }
}
