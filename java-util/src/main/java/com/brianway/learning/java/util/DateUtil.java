package com.brianway.learning.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期工具类
 * 
 * 
 */
public class DateUtil {
    /**
     * Default date format.
     */
    public static final String FORMAT_DEFAULTPATTERN = "yyyy-MM-dd HH:mm:ss"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_DATE = "yyyy-MM-dd"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_DATE_PATH = "yyyy/M/d"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_TIME = "HH:mm:ss"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_DATETIME = "yyyyMMddHHmmss"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_DATETIME_FULL = "yyyyMMddHHmmssSSS"; //$NON-NLS-1$

    public static final String FORMAT_YYYYMMDD = "yyyyMMdd"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_MILL = "yyyy-MM-dd HH:mm:ss.SSS"; //$NON-NLS-1$

    public static final String FORMAT_DEFAULTPATTERN_MONTH = "yyyy-MM";

    public static final String FORMAT_YYYYMM = "yyyyMM"; //$NON-NLS-1$

    public static final String FORMAT_MMDDHHMMSS = "MMddHHmmss"; //$NON-NLS-1$

    public static final long DAY = 60 * 60 * 24 * 1000;

    public static final long HOUR = 60 * 60 * 1000;

    public static final long MINUTE = 60 * 1000;

    public static final String HOUR_0 = " 00:00:00";

    public static final String HOUR_23 = " 23:59:59";

    /**
     * 日期间隔
     */
    public static final String INTERVAR_DAY = "day";// 本日

    public static final String INTERVAR_3DAY = "3day";// 3日内

    public static final String INTERVAR_HOUR = "hour";// 本小时内
    
    public static final int NO_3 = 3;
    public static final int NO_7 = 7;
    public static final int NO_10 = 10;
    public static final int NO_1000 = 1000;
    public static final int NO_23 = 23;
    public static final int NO_59 = 59;
    
    /**
    * 日期转换成字符串
    * @param date
    * @return str
    */
    public static String dateToStr(Date date) {
      
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String str = format.format(date);
       return str;
    } 
    /**
    * 字符串转换成日期
    * @param str
    * @return date
    */
    public static Date strToDate(String str) {
      
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date = null;
       try {
        date = format.parse(str);
       } catch (ParseException e) {
        e.printStackTrace();
       }
       return date;
    }

    /**
     * 根据日期间隔标志，转换得到日期字符串
     * 
     * @param interverStr
     * @return
     */
    public static String transInterverDateToString(String interverStr) {
        String ret = null;
        if (interverStr != null) {
            Date temp = transInterverDate(interverStr);
            if (temp != null) {
                ret = getFormattedDate(temp);
            }
        }
        return ret;
    }

    /**
     * 根据日期间隔标志，转换得到日期字符串
     * 
     * @param interverStr
     * @return
     */
    public static Date transInterverDate(String interverStr) {
        Date ret = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if (INTERVAR_DAY.equals(interverStr)) {
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        } else if (INTERVAR_3DAY.equals(interverStr)) {
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - NO_3);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        } else if (INTERVAR_HOUR.equals(interverStr)) {
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        ret = cal.getTime();
        return ret;
    }

    /**
     * 转换时间长整型
     * 
     * @param interverStr
     * @return
     */
    public static long transInterverDateLong(String interverStr) {
        Date ret = transInterverDate(interverStr);
        return ret.getTime();
    }

    /**
     * 根据参数在当前时间下，增加相应的时间。
     * 
     * @param dayhourminute [?:?:?]
     * @return
     */
    public static Date addDayHourMinute(String dayhourminute) {
        if (dayhourminute != null && dayhourminute.trim().length() > 0) {
            String t[] = dayhourminute.split(":");
            if (t != null && t.length == NO_3) {
                long _d = new Integer(t[0]).intValue();
                long _h = new Integer(t[1]).intValue();
                long _m = new Integer(t[2]).intValue();
                long dt = new Date().getTime();
                dt = dt + _d * DAY + _h * HOUR + _m * MINUTE;
                return new Date(dt);
            }
        }
        return null;
    }

    public static int getCurrentIntMMddHHmmss() {
        String tmp = getFormatMMddHHmmss(new Date());
        return Integer.parseInt(tmp);
    }

    public static int getCurrentIntMMddHHmmss(Date date) {
        String tmp = getFormatMMddHHmmss(date);
        return Integer.parseInt(tmp);
    }

    
    public static String getFormatMMddHHmmss(Date date) {
        return getFormattedDate(date, FORMAT_MMDDHHMMSS);
    }

    public static String getFormatDateTimeMill(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_MILL);
    }

    public static String getFormatYYYYMMDD(Date date) {
        return getFormattedDate(date, FORMAT_YYYYMMDD);
    }

    public static String getFormatDateTime(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_DATETIME);
    }

    public static String getFormatDateTimeFull(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_DATETIME_FULL);
    }

    public static String getFormatMonth(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_MONTH);
    }

    public static String getFormattedDate(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN);
    }

    public static String getFormatDate(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_DATE);
    }

    public static String getFormatTime(Date date) {
        return getFormattedDate(date, FORMAT_DEFAULTPATTERN_TIME);
    }

    public static String getFormatTimeYYYYYMM(Date date) {
        return getFormattedDate(date, FORMAT_YYYYMM);
    }

    public static String getFormattedDate(Date date,
                                          String formatPattern) {
        if (formatPattern == null) {
            formatPattern = FORMAT_DEFAULTPATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
        String fd = sdf.format(date);
        return fd;
    }

    public static String getCurrentDateMinus(String endStr) {
        String ret = null;
        Date endDate = getDateForFormat(endStr);
        if (null != endDate) {
            ret = getDateMinus(new Date(), endDate);
        }
        return ret;
    }

    public static Date getDateForFormat(String dateStr) {
        Date t = null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DEFAULTPATTERN);
        try {
            t = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("getDateForFormat()" + e.getMessage());
            t = null;
        }
        return t;
    }

    public static Date getDateForFormat(String dateStr,
                                        String dateFormat) {
        Date t = null;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            t = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("getDateForFormat()" + e.getMessage());
            t = null;
        }
        return t;
    }

    /**
     * 
     * @param dateStr
     * @return "HHmmssdd..."
     */
    public static String getDateMinus(Date beginDate,
                                      Date endDate) {
        String ret = null;
        if (beginDate != null && endDate != null) {
            long b = beginDate.getTime();
            long e = endDate.getTime();
            long temp = e - b;
            if (temp > 0) {
                long currentDay = temp / DAY;
                temp = temp % DAY;
                long currentHour = temp / HOUR;
                temp = temp % HOUR;
                long currentMinute = temp / MINUTE;
                temp = temp % MINUTE;
                long currentSecond = temp / NO_1000;
                StringBuffer sb = new StringBuffer();
				if (currentHour < NO_10) {
                    sb.append(' ');
                }
                sb.append(currentHour);
                if (currentMinute < NO_10) {
                    sb.append(' ');
                }
                sb.append(currentMinute);
                if (currentSecond < NO_10) {
                    sb.append(' ');
                }
                sb.append(currentSecond);
                sb.append(currentDay);
                ret = sb.toString();
            }
        }

        return ret;
    }

    /**
     * 
     * @param dateStr
     * @return seconds
     */
    public static long getIntByDateMinus(Date beginDate,
                                         Date endDate) {
        long ret = 0;
        if (beginDate != null && endDate != null) {
            long b = beginDate.getTime();
            long e = endDate.getTime();
            ret = (e - b) / NO_1000;
        }
        return ret;
    }

    /**
     * 
     * @param endStr
     * @return seconds
     */
    public static long getIntMinusByCurrentDate(String endStr,String format) {
        long ret = 0;
        Date endDate = getDateForFormat(endStr,format);
        if (null != endDate) {
            ret = getIntByDateMinus(endDate, new Date());
        }
        return ret;
    }

    
    public static long getMinutsByDate(String beginStr,
                                       String endStr) {
        long ret = 0;
        Date beginDate = getDateForFormat(beginStr);
        Date endDate = getDateForFormat(endStr);
        if (null != endDate && null != beginDate) {
            ret = getIntByDateMinus(beginDate, endDate);
        }
        return ret;
    }

    /**
     * Returns a date object which is the midnight of the input date.
     * 
     * @param date The input date
     * @return date The midnight date.
     */
    public static Date getDateMidnight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, NO_23);
        cal.set(Calendar.MINUTE, NO_59);
        cal.set(Calendar.SECOND, NO_59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定今天的零时
     * 
     * @return
     */
    public static String getTodayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return getFormattedDate(cal.getTime());
    }

    /**
     * 指定指定日期的零时
     * 
     * @return
     */
    public static String getZeroHour(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return getFormattedDate(cal.getTime());
    }

  
    
    /**
     * 当前日期减一个月
     * @return
     */
    public static String getNextMonth(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return getFormatTimeYYYYYMM(cal.getTime());
    }

    public static String getDataTime(long millis) {
        // 取当前时间
        DateFormat df = new SimpleDateFormat(FORMAT_DEFAULTPATTERN_MILL);
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return df.format(new Date(millis));
    }

    public static String getDatePath(Date date) {
        String t = null;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DEFAULTPATTERN_DATE_PATH);
        t = sdf.format(date) + "/";
        return t;
    }
    
    
    public static String getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) + "";
    }

    public static String getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        Integer currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth < NO_10) {
            return "0" + currentMonth;
        }
        return currentMonth.toString();
    }

    public static String getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        Integer currentDay = cal.get(Calendar.DATE);
        if (currentDay < NO_10) {
            return "0" + currentDay;
        }
        return currentDay.toString();
    }
    
    /**
     * 验证给定日期是否是当天时间
     * 
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        Calendar calendarBegin = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarBegin.set(calendarBegin.get(Calendar.YEAR), calendarBegin.get(Calendar.MONTH), calendarBegin
            .get(Calendar.DATE), 0, 0, 0);
        calendarEnd.set(calendarBegin.get(Calendar.YEAR), calendarBegin.get(Calendar.MONTH), calendarBegin
            .get(Calendar.DATE), NO_23, NO_59, NO_59);
        return calendarBegin.getTimeInMillis() <= date.getTime() && calendarEnd.getTimeInMillis() >= date.getTime();

    }
    
    /**
     * 时间转换为毫秒
     * 
     * @param date
     * @return
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }
    
    
    /**
     * 判断第一个时间是否在第二个时间之后
     * 
     * @param base 第一个时间参数
     * @param compare 第二个时间参数
     * @return true如果第一个时间晚于第二个时间，否则返回false
     */
    public static boolean isAfter(Date base, Date compare) {
        if (getMillis(base) - getMillis(compare) > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * 添加获取减少指定天数
     * @param date
     * @return
     */
    public static Date changeDays(Date date,int days ){
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(date);
    	int day=c.get(Calendar.DATE); 
    	c.set(Calendar.DATE,day+days); 
    	return c.getTime();
    }
    
    /**
     * 添加获取减少指定天数
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(date);
    	int day = c.get(Calendar.DAY_OF_WEEK)-1;
    	if (day==0) {
    		day=NO_7;
		}
    	return day;
    }

	/**
	 * 计算时间差秒数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long timeDifference(Date startDate,Date endDate){
		long s=startDate.getTime();
		long e=endDate.getTime();
		return ((e-s)/ NO_1000)+1;
	} 
	/**
	 * 获取日期为周几
	 * @param date
	 * @return
	 */
	public static int getWeekOfDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

    /**
     * 参数有小时、分、秒、相比今天的日期，今天就输入0，明天输入1，昨天输入-1，以此类推
     * 毫秒是可选参数，可以输入也可以不输入，毫秒的取值范围是0到999)
     * @param hour
     * @param minute
     * @param second
     * @param addDay
     * @param args
     * @return
     */
    public static Date getNeedTime(int hour,int minute,int second,int addDay,int ...args){
        Calendar calendar = Calendar.getInstance();
        if(addDay != 0){
            calendar.add(Calendar.DATE,addDay);
        }
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        if(args.length==1){
            calendar.set(Calendar.MILLISECOND,args[0]);
        }
        return calendar.getTime();
    }
}
