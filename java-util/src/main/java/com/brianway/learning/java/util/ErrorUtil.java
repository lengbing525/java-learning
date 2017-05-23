package com.brianway.learning.java.util;

/**
 * Created by lengbing on 2017/5/23.
 */
public class ErrorUtil {
    /**
     * 输出和控制台相同格式的日志信息
     * @param e
     * @return
     */
    public static String getStackMsg(Exception e) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * 输出和控制台相同格式的日志信息
     * @param e
     * @return
     */
    public static String getStackMsg(Throwable e) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }
}
