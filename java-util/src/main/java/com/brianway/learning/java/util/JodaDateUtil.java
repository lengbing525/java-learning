package com.brianway.learning.java.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lengbing on 2017/5/23.
 */
public class JodaDateUtil {
    private static final Logger logger = LoggerFactory.getLogger(JodaDateUtil.class);
    //String类型的时间撮转LocalDate
    public static LocalDate getLocalDate(String dateStr) {
        LocalDate localDate = null;
        if (!StringUtils.isBlank(dateStr)) {
            localDate = new LocalDate(Long.valueOf(dateStr));
        } else {
            localDate = new LocalDate();
        }
        return localDate;
    }
    //long类型的时间撮转LocalDate
    public static LocalDate getLocalDate(long date) {
        return new LocalDate(date);
    }
    //获取当天的Date(去掉时分秒，只有年月日)
    public static Date getToday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime);
        return date.toDate();
    }
    //获取昨天的Date(去掉时分秒，只有年月日)
    public static Date getYesterday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.minusDays(1));
        return date.toDate();
    }
    //获取明天的Date(去掉时分秒，只有年月日)
    public static Date getTomorrow() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusDays(1));
        return date.toDate();
    }
    //获取这周开始的星期一的时间
    public static Date getThisWeekStartday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime);
        return date.dayOfWeek().withMinimumValue().toDate();
    }
    //获取上周开始的星期一的时间
    public static Date getLastWeekStartday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.minusWeeks(1));
        return date.dayOfWeek().withMinimumValue().toDate();
    }
    //获取这个月开始的星期一的时间
    public static Date getThisMonthStartday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime);
        return date.dayOfMonth().withMinimumValue().toDate();
    }
    //获取上个月开始的星期一的时间
    public static Date getLastMonthStartday() {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.minusMonths(1));
        return date.dayOfMonth().withMinimumValue().toDate();
    }
    /**
     * 如果传递的days大于0，表示得到boundary之后的days的日期
     * 如果传递的days小于0，表示得到boundary之前的days的日期
     */
    public static Date getSpecificDay(Date boundary, int days) {
        DateTime dateTime = new DateTime(boundary);
        LocalDate date = null;
        if (days < 0) {
            date = new LocalDate(dateTime.minusDays(-days));
        } else {
            date = new LocalDate(dateTime.plusDays(days));
        }
        return date.toDate();
    }
    //立即数：相当于高级语言中的常量（常数），它是直接出现在指令中的数，不用存储在寄存器或存储器中的数，如指令ADD AL,06H中的06H即为立即数
    //获取两个时间的差距的天数
    public static int diffDays(Date date1, Date date2)
    {
        Date bigDay = null;
        Date smallDay = null;
        if (date1.after(date2)) {
            bigDay = date1;
            smallDay = date2;
        } else {
            bigDay = date2;
            smallDay = date1;
        }
        //return date1.getTime() / (24*60*60*1000) - date2.getTime() / (24*60*60*1000);
        return (int) (bigDay.getTime() / 86400000 - smallDay.getTime() / 86400000);//用立即数，减少乘法计算的开销
    }
    //获取的时区时间和实际的时间差距8个小时
    public static Date convertByTimeZone(Date date, String timeZoneStr) {
        if (null == timeZoneStr) {
            timeZoneStr = "GMT+00";
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sf.setTimeZone(TimeZone.getTimeZone(timeZoneStr));
        Date newDate = null;
        try {
            newDate = sf1.parse(sf.format(date));
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return newDate;
    }
    //测试一下方法：
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String startDate = "1414024810000";//(2014/10/23 8:40:10)
        LocalDate localDate1 = getLocalDate(startDate);
        LocalDate localDate2 = getLocalDate(Long.valueOf(startDate));
        System.out.println("localDate1 = " + localDate1 + ",localDate2 = " + localDate2);
        Date date1 = getToday();
        Date date2 = getYesterday();
        Date date3 = getTomorrow();
        System.out.println("date1 = " + sdf.format(date1) + " ,date2 = " + sdf.format(date2) + " ,date3 = " + sdf.format(date3));
        Date date4 = getThisWeekStartday();
        Date date5 = getLastWeekStartday();
        Date date6 = getThisMonthStartday();
        Date date7 = getLastMonthStartday();
        System.out.println("date4 = " + sdf.format(date4) + " ,date5 = " + sdf.format(date5) + " ,date6 = " + sdf.format(date6) + " ,date7 = " + sdf.format(date7));
        //得到今天之前的倒数两天的日期 今天是10月23日
        System.out.println(sdf.format(getSpecificDay(new Date(), -2)));
        System.out.println(sdf.format(getSpecificDay(new Date(), 2)));
        int result = diffDays(date3, date1);
        int result1 = diffDays(date1, date3);
        System.out.println("result = " + result + ", result1 = " + result1);
        System.out.println(convertByTimeZone(new Date(), "GMT+00"));
        System.out.println(sdf.format(convertByTimeZone(new Date(), "GMT+00")));
    }
}
