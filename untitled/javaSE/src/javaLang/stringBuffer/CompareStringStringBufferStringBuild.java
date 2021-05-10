package javaLang.stringBuffer;

/**
 * @author ChenDan
 * @create 2021-04-20
 * @desc
 * 创建时间 ： StringBuffer < StringBuilder << String
 */
public class CompareStringStringBufferStringBuild {
    public static void main(String[] args) {
        time();
    }

    public static void time() {
        long startTime;
        long endTime;
        int loopNum = 2000;

        String str = "";
        StringBuffer buffer = new StringBuffer(str);
        StringBuilder builder = new StringBuilder(str);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopNum; i++) {
            str = str + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopNum; i++) {
            buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < loopNum; i++) {
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (endTime - startTime));

    }
}
