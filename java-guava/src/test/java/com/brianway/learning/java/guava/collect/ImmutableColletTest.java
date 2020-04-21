package com.brianway.learning.java.guava.collect;

import java.util.HashMap;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * ImmutableColletTest
 *
 *
 * 不可变对象有很多优点，包括：

 当对象被不可信的库调用时，不可变形式是安全的；
 不可变对象被多个线程调用时，不存在竞态条件问题
 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 不可变对象因为有固定不变，可以作为常量来安全使用。
 创建对象的不可变拷贝是一项很好的防御性编程技巧。Guava为所有JDK标准集合类型和Guava新集合类型都提供了简单易用的不可变版本。
 JDK也提供了Collections.unmodifiableXXX方法把集合包装为不可变形式，但我们认为不够好：

 笨重而且累赘：不能舒适地用在所有想做防御性拷贝的场景；
 不安全：要保证没人通过原集合的引用进行修改，返回的集合才是事实上不可变的；
 低效：包装过的集合仍然保有可变集合的开销，比如并发修改的检查、散列表的额外空间，等等。
 如果你没有修改某个集合的需求，或者希望某个集合保持不变时，把它防御性地拷贝到不可变集合是个很好的实践。
 *
 * @author lengbing
 * @version 1.0
 * @date 2018/4/28 下午12:05
 * @since 1.8
 */
public class ImmutableColletTest {



    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
        ImmutableMap immutableMap = ImmutableMap.copyOf(hashMap);
        ImmutableMap.of("a", 1, "b", 2);
        ImmutableSet.of("a", "b","c");

    }

}
