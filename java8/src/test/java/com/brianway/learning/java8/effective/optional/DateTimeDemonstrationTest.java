package com.brianway.learning.java8.effective.optional;

import com.brianway.learning.java.util.DateUtil;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by lengbing on 2017/5/23.
 */
public class DateTimeDemonstrationTest {
    @Test
    public void test1() {
        // 获取当前日期时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("获取当前日期时间:"+dateTime1);


        LocalDate date1 = LocalDate.now();
        System.out.println("获取当前日期: " + date1);

        LocalTime time1 = LocalTime.now();
        System.out.println("获取当前时间: " + time1);

        // 获取当前时间的时间戳
        Instant instant = Instant.now();
        // 因为中国在东八区，所以这句输出的时间跟我的电脑时间是不同的
        System.out.println(instant);

        // 既然中国在东八区，则要偏移8个小时，这样子获取到的时间才是自己电脑的时间
        OffsetDateTime dateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(dateTime);


    }

    /**
     * Date转LocalDate：
     */
    @Test
    public void test2() {
        Date date2 = new Date();
        LocalDate localDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    /**
     * LocalDate 转 Date:
     */
    @Test
    public void test3() {
        LocalDateTime localDate = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atZone(zone).toInstant();
        Date date = Date.from(instant);
        System.out.println(DateUtil.dateToStr(date));
    }

    @Test
    public void test4() {
        // 获取预定义的格式，DateTimeFormatter类预定了很多种格式
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        // 获取当前日期时间
        LocalDate now = LocalDate.now();
        // 指定格式化器格式日期时间
        String strNow = now.format(dtf);
        System.out.println(strNow);

        // 自定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String strNow2 = now.format(formatter);
        System.out.println(strNow2);

        // 将字符串转换成日期
        LocalDate date = LocalDate.parse(strNow2, formatter);
        System.out.println(date);

    }


    @Test
    public void test5() {
        //是否是闰年
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.isLeapYear());

        //计算相隔多少天、多少周、多少月.......
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        System.out.println(localDate.toEpochDay()-java8Release.toEpochDay());
        System.out.println(java8Release.until(localDate, ChronoUnit.DAYS));
        System.out.println(java8Release.until(localDate, ChronoUnit.WEEKS));
        System.out.println(java8Release.until(localDate, ChronoUnit.MONTHS));
        System.out.println(java8Release.until(localDate, ChronoUnit.YEARS));
        System.out.println(java8Release.until(localDate, ChronoUnit.HOURS));
    }


}
