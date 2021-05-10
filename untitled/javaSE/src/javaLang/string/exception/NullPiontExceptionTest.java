package javaLang.string.exception;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc NullPiontException : 空指针
 */
public class NullPiontExceptionTest {
    public static void main(String[] args) {
        String str1 = new String("CHINA @ 中国文化\n.123");
        String str2 = null;
        System.out.println(str2.compareTo(str1));
    }
}
