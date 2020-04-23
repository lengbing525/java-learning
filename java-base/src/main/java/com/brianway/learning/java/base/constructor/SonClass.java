package com.brianway.learning.java.base.constructor;

/**
 *
 * @author Brian
 * @date 2016/4/14
 *
 *
 * 静态域 -> 构造代码块 -> 构造方法
 * 静态域包括静态变量、静态块, 静态变量和静态块的执行顺序由位置决定
 *
 * 静态代码块（static{}）在类加载的时候执行一次。
 * 构造代码块（{}内的部分）在每一次创建对象时执行，始终在构造方法前执行。
 * 构造方法在新建对象时调用（ 就是new的时候 ）
 *
 *
 */
public class SonClass extends FatherClass {

    private static int countSon;

    {
        System.out.println("子类的构造代码块");
    }

    static {
        System.out.println("子类可以访问父类的静态属性count " + count);
        System.out.println("子类的静态属性countSon初始化:" + countSon);
    }

    public SonClass(String name) {
        //super(name);
        System.out.println("执行了子类的构造方法SonClass(String name) " + name);
    }

    public SonClass() {
        System.out.println("执行了子类的无参构造方法");
    }

    public static void main(String[] args) {
        new SonClass("aaa");
        new SonClass();
    }

}

/*
父类的静态属性count初始化:10
子类可以访问父类的静态属性count 10
子类的静态属性countSon初始化:0
执行了父类的无参构造方法
执行了子类的构造方法SonClass(String name) aaa
执行了父类的无参构造方法
执行了子类的无参构造方法
 */
