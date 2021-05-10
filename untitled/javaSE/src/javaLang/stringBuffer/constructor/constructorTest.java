package javaLang.stringBuffer.constructor;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc 动态字符串
 * String - final class String - final char value[0] -
 * StringBuffer - final class StringBuffer - char[16] value - 多线程安全
 * StringBuild - final class StringBuilder - char[16] value - 多线程不安全+不同步
 */
public class constructorTest {
    public static void main(String[] args) {
        String str = "kwnfds";
        StringBuffer sb = new StringBuffer();  // char[16]
        StringBuffer sb1 = new StringBuffer("kjhsdk "); // char[16]+"kjhsdk"
        StringBuffer sb2 = new StringBuffer(12); // char[12]

        StringBuilder sbd = new StringBuilder("ndjf");
    }
}
