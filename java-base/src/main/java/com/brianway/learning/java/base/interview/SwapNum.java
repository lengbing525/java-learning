package com.brianway.learning.java.base.interview;

/**
 * Created by lengbing on 2017/4/1.
 */
public class SwapNum {
    public static void swap1(int a,int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a:"+a+"---"+"b:"+b);
    }
    public static void swap2(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a:"+a+"---"+"b:"+b);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        swap1(a, b);
        swap2(a, b);

    }
}
