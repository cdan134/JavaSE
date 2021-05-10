package javaLang.stringBuffer.exception;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc
 */
public class StringIndexOutOfBoundExceptionTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.insert(12,"123"); // 查找的位置超过现有容量（16个缓存不算空间）
        sb.delete(12,43);  // 起始位置一定要在为已有数据内才可以
    }
}
