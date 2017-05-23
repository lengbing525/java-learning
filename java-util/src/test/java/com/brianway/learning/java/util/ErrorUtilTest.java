package com.brianway.learning.java.util;

import org.junit.Test;

/**
 * Created by lengbing on 2017/5/23.
 */

public class ErrorUtilTest{
    @Test
    public void test1(){
        try {
            String stemp = null;
            System.out.println(stemp.indexOf("i"));
        } catch (Exception e) {
            System.out.println("------------------error----------------:"+ErrorUtil.getStackMsg(e));
            e.printStackTrace();
        }
    }
}
