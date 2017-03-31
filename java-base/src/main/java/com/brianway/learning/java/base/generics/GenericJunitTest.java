package com.brianway.learning.java.base.generics;

import org.junit.Test;

/**
 * Created by lengbing on 2017/3/31.
 */
public class GenericJunitTest{
    @Test
    public void genericTest1(){
        Holder<String> name = new Holder<String>("corn");
        Holder<Integer> age = new Holder<Integer>(712);
        System.out.println("name class:" + name.getClass());      // com.qqyumidi.Box
        System.out.println("age class:" + age.getClass());        // com.qqyumidi.Box
        System.out.println(name.getClass() == age.getClass());    // true
    }
}
