package javaLang.thread.method;

import java.io.IOException;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc
 */
public class MethodTest {
    public static void main(String[] args) {
        methods();

//        propertyMethod();


    }

    /* 系统属性， key值可取范围
    * java.version Java 运行时环境版本
    * java.vendor Java 运行时环境供应商
    * java.vendor.url Java 供应商的 URL
    * java.home Java 安装目录
    * java.vm.specification.version Java 虚拟机规范版本
    * java.vm.specification.vendor Java 虚拟机规范供应商
    * java.vm.specification.name Java 虚拟机规范名称
    * java.vm.version Java 虚拟机实现版本
    * java.vm.vendor Java 虚拟机实现供应商
    * java.vm.name Java 虚拟机实现名称
    * java.specification.version Java 运行时环境规范版本
    * java.specification.vendor Java 运行时环境规范供应商
    * java.specification.name Java 运行时环境规范名称
    * java.class.version Java 类格式版本号
    * java.class.path Java 类路径
    * java.library.path 加载库时搜索的路径列表
    * java.io.tmpdir 默认的临时文件路径
    * java.compiler 要使用的 JIT 编译器的名称
    * java.ext.dirs 一个或多个扩展目录的路径
    * os.name 操作系统的名称
    * os.arch 操作系统的架构
    * os.version 操作系统的版本
    * file.separator 文件分隔符（在 UNIX 系统中是“/”）
    * path.separator 路径分隔符（在 UNIX 系统中是“:”）
    * line.separator 行分隔符（在 UNIX 系统中是“/n”）
    * user.name 用户的账户名称
    * user.home 用户的主目录
    * user.dir 用户的当前工作目录
    *
    * public static String getProperty(String key)  获取属性特点
    * public static String clearProperty(String key)  清除属性特点
    * public static String setProperty(String key, String value)  设置属性特点
    * * */
    public static void propertyMethod() {
        System.out.println(System.getProperty("user.name"));  // 这个是Property类的部分？？？？
        System.clearProperty("user.name");
        System.setProperty("user.name","temp");
        System.out.println(System.getProperty("user.name"));
    }

    /*
    * public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length)
                                        复制对象数组
    * public static Console console()  这个是Java虚拟机的一个类？？？？
    * public static native long currentTimeMillis()  当前时间
    * public static native long nanoTime()  当前时间
    * public static void exit(int status)  退出当前程序，非0即为异常退出 =Runtime.getRuntime().exit(status);
    * public static void gc()  垃圾回收 =Runtime.getRuntime().gc()
    * public static java.util.Map<String,String> getenv() 当前系统环境的映射图????
    * public static SecurityManager getSecurityManager() 获取系统安全接口 null ????
    * public static native int identityHashCode(Object x) 指定对象的哈希码 ？？？？
    * public static Channel inheritedChannel() throws IOException 继承信道 ？？？？
    * public static void load(String filename) 加载指定文件
    * public static void loadLibrary(String libname) 加载指定库
    * */
    public static void methods() {
        String[] str1 = {"wqe","bsajbds","dskjhdjksa","basjdbsa","bsajkhd"};
        String[] str2 = new String[str1.length];
        System.arraycopy(str1,2,str2,2,3);
        System.out.println(System.console());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
//        System.exit(0);
        System.gc();
//        System.out.println(System.getenv());
//        Map<String, String> map = System.getenv();
//        for(Iterator<String> itr = map.keySet().iterator(); itr.hasNext();) {
//            String key = itr.next();
//            System.out.println(key + "=" + map.get(key));
//        }
        System.out.println(System.getSecurityManager());
        System.out.println(System.identityHashCode(str1));
        try {
            System.out.println(System.inheritedChannel());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.load("/usr/local/temp.txt");
        System.loadLibrary("/usr/local/temp.txt");
    }

}
