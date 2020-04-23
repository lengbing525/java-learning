package com.brianway.learning.java.base.initialize;

/**
 * Foo
 *
 * @author lengbing
 * @version 1.0
 * @date 2020/4/21 下午4:52
 * @since 1.8
 *
 * final使用前必须初始化,且final变量的初始化只有三种方式:
 *  1、声明时初始化
 *  2、构造函数中初始化
 *  3、或者在代码块中初始化
 * static final使用前必须初始化,且final变量的初始化只有两种方式:
 *  1、声明时初始化
 *  2、静态代码块初始化
 *
 * (1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
 * (2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
 * (3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
 * (4) 父类构造函数
 * (5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
 * (6) 子类构造函数
 *
 * 参考：https://www.nowcoder.com/questionTerminal/eabef9f274144ec0ac79653404e05433?orderByHotValue=1&mutiTagIds=134&page=1&onlyReference=false
 */
public class Foo {

    final int i;

    {
        i = 0;
    }

    /*Foo(){
        i = 0;
    }*/

    int j;
    public void doSomething() {
        System.out.println(++j + i);
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(5/2));
    }
    
}
