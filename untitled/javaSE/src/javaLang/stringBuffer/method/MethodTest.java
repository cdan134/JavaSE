package javaLang.stringBuffer.method;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc
 */
public class MethodTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
//        appendTest(sb);

        insertTest(sb);
        other(sb);

    }

    /*
    public synchronized StringBuffer append(xx) : 同步方法 加入int/float/xx等类型方法
    */
    public static void appendTest(StringBuffer sb) {
        sb.append(1);
        sb.append(113214.237487328);
        sb.append(113214.2374);
        sb.append('a');
        sb.append(new char[]{'!', '@'});
        sb.append(new char[]{'!', '@', '#'}, 0, 2);
        sb.append("new char[]{'!', '@','#'},0,2");
        sb.append(sb);

        System.out.println(sb);
        System.out.println(sb.capacity());
    }

    /*
    public  StringBuffer insert(int offset, xx) 指定位置放入boolean/char/char[]/double/str等类型数据
    */
    public static void insertTest(StringBuffer sb) {
        sb.insert(0, true);
        sb.insert(1, 'q');

        System.out.println(sb);
        System.out.println(sb.capacity());
    }

    /*
    public synchronized int capacity() - 容量 > 16
    */
    public static void other(StringBuffer sb) {
        System.out.println(sb);
        System.out.println(sb.capacity());
        sb.ensureCapacity(17);  // ??怎么计算的没看懂
        System.out.println(sb.length());

        sb.delete(5,13);  // 删除的是已经定义的信息
        sb.deleteCharAt(3);

        System.out.println(sb);
        System.out.println(sb.capacity());
//        System.out.println(sb.length());
    }
}

