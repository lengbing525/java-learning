package com.brianway.learning.java.base.interview;

/**
 * 找出数组中只出现一次的数,自己与自己异或结果为0
 * Created by lengbing on 2017/4/1.
 */
public class InterviewTest1 {

    public static int singleNumber(int[] a) {
        int result = a[0];
        for(int i=1;i<a.length;i++){
            result ^= a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1,5,7,7,9,9,4,4};
        System.out.println(singleNumber(array));
    }
}
