package javaLang.thread.runtime;

/**
 * @author ChenDan
 * @create 2021-04-19
 * @desc
 */
public class Runtime2{
    public static void main(String args[])throws Exception{
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }
}

