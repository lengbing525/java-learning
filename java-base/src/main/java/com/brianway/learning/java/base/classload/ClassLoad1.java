package com.brianway.learning.java.base.classload;

import java.util.Random;

/**
 *
 * 能够在编译时期确定的，叫做编译常量；运行时才能确定下来的，叫做运行时常量。编译常量不会引起类的初始化，而运行常量就会。
 * 去掉x的final修饰则会引起类的初始化
 * Created by lengbing on 2017/3/29.
 */
public class ClassLoad1 {


    public static void main(String args[]){
        System.out.println(FinalTest.x);
        System.out.println(FinalTest2.x);
    }

}
class FinalTest{
    public static final int x =6/3;
    static {
        System.out.println("FinalTest static block");
    }
}
class FinalTest2{
    public static final int x =new Random().nextInt(100);
    static {
        System.out.println("FinalTest2 static block");
    }
}
