package com.brianway.learning.java.guava.Base;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import org.junit.Test;

/**
 * StringUtilTest
 *
 * @author lengbing
 * @version 1.0
 * @date 2018/4/12 下午3:10
 * @since 1.8
 */
public class StringUtilTest {

    @Test
    public void JoinerTest(){
        System.out.println(Joiner.on(";").skipNulls().join("A", null, "B", "C"));
        System.out.println(Joiner.on(";").useForNull("Hello").join("A", null, "B", "C"));

        //拼接数组
        String[] a = new String[]{"A","B","C"};
        System.out.println(Joiner.on(";").skipNulls().join(a));

        //append到StringBuilder
        StringBuilder builder = new StringBuilder();
        Joiner joiner = Joiner.on(",").skipNulls();
        joiner.appendTo(builder, "Hello", "Guava");
        System.out.println(builder); //Hello,Guava

        //拼接map
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(map)); //key3=value3,key2=value2,key1=value1


    }
}
