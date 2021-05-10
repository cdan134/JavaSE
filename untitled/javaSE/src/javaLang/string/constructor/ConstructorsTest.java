package javaLang.string.constructor;

import java.io.UnsupportedEncodingException;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc String的创建方法
 * 直接创建
 *      public String(String original)
 * byte数组转换
 *      public String(byte bytes[], , , ,) : 根据编码格式获取字节组
 *          @int offset 起始位置
 *          @int length 长度
 *          @String charsetName 编码方式
 *          @int length 长度
 *      public String(char value[], , , ,) : 根据编码格式获取字符组
 *          @int offset 起始位置
 *          @int count 数量
 *      public String(int[] codePoints, int offset, int count) : 指定整数组对应的ASCII码
 *
 * Charset
 *      Unicode : 统一码
 *      UTF-8 ：针对Unicode的可变长度字符编码（定长码）
 *      GBK ：GBXXXX,显示中文 - gb2312
 *      BIG5 : 繁体中文
 *      ASCII : 26个基本拉丁字母、阿拉伯数目字和英式标点符 - 现代美国英语
 */
public class ConstructorsTest {
    public static void main(String[] args) {
        String str1 = new String("CHINA @ 中国文化");

        byte[] byte1 = new byte[0];
        try {
            byte1 = str1.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String str2 = null;
        try {
            str2 = new String(byte1,2,12,"gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        char[] char1 = str1.toCharArray();
        String str3 = new String(char1,2,54);

        int[] codePoint = new int[] {2,3,65,2};
        String str4 = new String(codePoint,2,2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }
}
