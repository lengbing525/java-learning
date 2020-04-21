package com.brianway.learning.java8.effective.optional;

import java.util.Optional;

import org.junit.Test;

/**
 * Test1
 *
 * @author lengbing
 * @version 1.0
 * @date 2018/4/17 下午5:14
 * @since 1.8
 */
public class Test1 {

    @Test
    public void test1() {
        Person person = new Person();
        Car car = new Car();
        Optional<Insurance> insurance = Optional.of(new Insurance("sb"));
        car.setInsurance(insurance);
        //person.setCar(car);

        Car carN = new Car();
        Optional<Insurance> insuranceN = Optional.of(new Insurance("sbNew"));
        carN.setInsurance(insuranceN);

        Car car1 = Optional.ofNullable(person).flatMap(person1 -> person1.getCar()).orElse(carN);
        System.out.println(car1.getInsurance().get().getName());
    }


    @Test
    public void test2() {
        Person person = new Person();
        Optional.ofNullable(person).ifPresent(person1 -> System.out.println("in"));
        System.out.println("---------------------------");
        person = null;
        Optional.ofNullable(person).ifPresent(person1 -> System.out.println("in"));
    }

    @Test
    public Person test3(){
        Person person = new Person();
        return Optional.ofNullable(person).orElse(new Person());
    }

}
