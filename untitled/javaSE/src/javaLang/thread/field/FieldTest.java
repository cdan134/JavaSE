package javaLang.thread.field;

import java.io.BufferedInputStream;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc
 * System.in是一个典型的连接控制台程序和键盘输入的InputStream流
 * System.out也经常用于打印程序的调试信息
 * System.err与System.out的运行方式类似，但它更多的是用于打印错误文本
 */
public class FieldTest {
    public static void main(String[] args) {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        System.out.println("System.out");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println();
        }

    }
}
