package javaLang.string.method;

import java.io.UnsupportedEncodingException;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc
 *
 */
public class MethodTest {
    public static void main(String[] args) {
        String str1 = new String("CHINA @ 中国文化\n.123");

//        indexString(str1);
//        other(str1);
//        addString(str1);
//        getString();
//        modifyString(str1);
        getString();
    }

    /*
    public char charAt(int index) : 指定位置数值
    public int codePointAt(int index) : 指定位置的ASCII值
    public int codePointBefore(int index) : 指定位置的前一个位置的ASCII值
    public int codePointCount(int beginIndex, int endIndex) : 返回unicode的代码数
    public boolean contains(CharSequence s) : 判断字符串中是否含有指定的char值序列
    public boolean startsWith(String prefix) : 判断字符串中是否以xx开头
    public boolean endsWith(String prefix) : 判断字符串中是否以xx结尾
    public int indexOf(xx, int fromIndex) : 参数所在锁定数组范围内的索引(不在的话返回-1，位置是字符串的索引位置)
    public int lastIndexOf(xx, int fromIndex) : 指定字符串范围内，最后一次出现xx的索引位置
    * */
    public static void indexString(String str) {
        System.out.println(str.charAt(12));
        System.out.println(str.codePointAt(5));
        System.out.println(str.codePointBefore(6));
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, 17));
        System.out.println(str.contains("I"));
        System.out.println(str.startsWith("I"));
        System.out.println(str.endsWith("I"));
        System.out.println(str.indexOf(' ',4));
        System.out.println(str.lastIndexOf(' ',4));
    }

    /*
    public String concat(String str) ： 连接两个字符串
    */
    public static void addString(String str) {
        String str1 = "null";
        System.out.println(str1.concat(str));
    }

    public static void delString(String str) {

    }

    /*
    public String replace(CharSequence target, CharSequence replacement) : 替换
    public String replaceAll(String regex, String replacement) : 全部替换
    public String replaceFirst(String regex, String replacement) : 第一次替换
    * */
    public static void modifyString(String str){
        String str1 = str.replace("C","o");
        String str2 = str.replaceAll("CH","o");
        String str3 = str.replaceFirst("CH","o");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    /*
    public int compareTo(String anotherString) ： 返回不同处ASCII值的差
    public int compareToIgnoreCase(String str) : 返回不同处ASCII值的差(忽略大小写)
    public boolean contentEquals(CharSequence cs) : 判断字符中是否与比较字符串相等
    public boolean equals(Object anObject) : 判断字符串与另外一个字符串相比是否相等
    public boolean equalsIgnoreCase(String anotherString) ： 判断字符串与另外一个字符串相比是否相等（忽略大小写）
    public boolean regionMatches(int toffset, String other, int ooffset, int len) : 截取位置是否相同
    public static String format(String format, Object... args) : 格式化输出
    public int hashCode() : 哈希值
    public int length() : 字符串的长度
    public boolean matches(String regex) : 是否符合正则表达式 ？？
    public int offsetByCodePoints(int index, int codePointOffset) : index所在位置+codePointOffset的索引
    public String toLowerCase() : 全部小写输出
    public String toUpperCase() : 全部大写输出
    public String toString() : 输出字符串信息
    */
    public static void other(String str) {
        String str1 = "null";
        System.out.println(str.compareTo(str1));
        System.out.println(str.compareToIgnoreCase(str1));
        System.out.println(str.contentEquals(str));

        System.out.println(str.equals(" "));
        System.out.println(str.equalsIgnoreCase(" "));

        System.out.println(str.regionMatches(12,str1,1,2));

        System.out.println(String.format("str的长度为：%d", str.length()));


        System.out.println(str.hashCode());
        System.out.println(str.length());
        System.out.println(str.matches("ss"));  // ？？？
        System.out.println(str.offsetByCodePoints(12, 5));

        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.toString());
    }

    /*
    public static String copyValueOf(char data[]) : 字符数组 To 字符串
    */
    public static void getString() {
        char[] char1 = new char[]{'I', 'L', 'I'};
        System.out.println(String.copyValueOf(char1));
        System.out.println(String.valueOf(2));
        System.out.println(String.valueOf('a'));
        System.out.println(String.valueOf(3.2));
        System.out.println(String.valueOf(3.2324546321312121));
        System.out.println(String.valueOf(123L));
        System.out.println(String.valueOf("dskjddjs"));
    }

    /*
    public byte[] getBytes() :  字符串 To 字节组
    public char[] toCharArray() : 字符串 To 字符组
    public String[] split(String regex, int limit) : 将字符串根据需求拆分
    public String substring(int beginIndex, int endIndex) : 截取一部分
    public String trim() : 忽略前后的空白
    */
    public static void transString(String str) {
        try {
            byte[] bytes = str.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        char[] chars = str.toCharArray();

        String[] strs1 = str.split(" ", 12);
        String str1 = str.substring(2,3);
        String str2 = str.trim();

    }
}


