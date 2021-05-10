package javaLang.string.exception;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc String index out of range  超出长度范围
 */
public class IndexOutOfBoundsExceptionTest {
    public static void main(String[] args) {
        String str1 = new String("CHINA @ 中国文化");

        char[] char1 = str1.toCharArray();
        String str2 = new String(char1,2,54);  // 长度超出范围
    }
}
