package com.brianway.learning.java.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by lengbing on 2017/5/23.
 */
public class Java8DateUtil {

    /**
     * 计算两个日期的差距
     * @param dateStart     开始时间
     * @param dateEnd       结束时间
     * @param chronoUnit     ChronoUnit.DAYS
     *                        ChronoUnit.WEEKS
     *                        ChronoUnit.MONTHS
     *                        ChronoUnit.YEARS
     *                        ChronoUnit.HOURS
     * @return
     */
    public static long dateBetween(Date dateStart,Date dateEnd,ChronoUnit chronoUnit){
        LocalDateTime localDateTimeStart = dateToLocalDateTime(dateStart);
        LocalDateTime localDateTimeEnd = dateToLocalDateTime(dateEnd);
        return localDateTimeStart.until(localDateTimeEnd,chronoUnit);
    }


    public static LocalDate dateToLocalDate(Date date){
        return  date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        return  date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date localDateToDate(LocalDate localDate){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }
}
