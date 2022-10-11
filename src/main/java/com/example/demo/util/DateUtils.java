package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类.
 *
 * Mar 15, 2018 11:07:11 AM
 *
 */
public class DateUtils {

    /**
     * 获取0点的时刻.
     * 
     * @param date
     *            时间
     * @return 0点时刻
     */
    public static Date getDateInZeroMiliSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    /**
     * 获取指定日期的日
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int day = now.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 指定日期加几天.
     * 
     * @param date
     *            当前日期
     * @param day
     *            增加天数
     * @return 计算后的日期
     */
    public static Date addDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 日期克隆.
     *
     * @param date
     *            日期
     * @return 克隆后的日期
     */
    public static Date dateClone(Date date) {
        if (date != null) {
            return (Date) date.clone();
        } else {
            return null;
        }
    }

    public static Date getNowTimeAndHoursMinutesSecondsToZero() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 将时分秒,毫秒域清零
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取前month月的日期(month为负时往后推，month为正时往前推)
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date getBeforeMonth(Date date, int month) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, -month);
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取当月第一天
     */
    public static Date getFirstDayOfMonth(Date newDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(newDate);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将时分秒,毫秒域清零
        toZeroByCalendar(c);
        return c.getTime();
    }

    /**
     * 获取当前日期后day天
     * 
     * @param date
     * @param day
     * @return
     */
    public static Date getAfterDay(Date date, int day) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, day);
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取当月最后一天
     */
    public static Date getLastDayOfMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    /**
     * 获取当月第一天
     */
    public static Date getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将时分秒,毫秒域清零
        toZeroByCalendar(c);
        return c.getTime();
    }

    /**
     * 获取当月最后一天
     */
    public static Date getLastDayOfMonth(Date newDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(newDate);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将时分秒,毫秒域清零
        toZeroByCalendar(ca);
        return ca.getTime();
    }

    private static void toZeroByCalendar(Calendar c) {
        // 将时分秒,毫秒域清零
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return;
    }

    /**
     * 获取指定日期的年
     * 
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int year = ca.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取指定日期的月
     * 
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int month = ca.get(Calendar.MONTH) + 1;
        return month;
    }

    public static String formatDate(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(d);
        return date;
    }

    public static Date formatDate(String d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    /**
     * 比较两个日期的大小
     * 
     * @param d1
     * @param d2
     * @return
     */
    public static Integer compart(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return null;
        }
        if (d1.getTime() > d2.getTime()) {
            return 1;
        } else if (d1.getTime() == d2.getTime()) {
            return 0;
        } else if (d1.getTime() < d2.getTime()) {
            return -1;
        } else {
            return null;
        }
    }
    
    public static String fmtDate(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String date = formatter.format(d);
        return date;
    }
    public static Date getDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = formatter.format(new Date());
        Date date = new Date();
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 判断两个日期是否同一天.
     * 
     * @param ms1
     *            日期1
     * @param ms2
     *            日期2
     * @return 是否同一天
     */
    public static boolean isSameDay(final long ms1, final long ms2) {
        int SECONDS_IN_DAY = 60 * 60 * 24;
        long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY && interval > -1L * MILLIS_IN_DAY && toDay(ms1) == toDay(ms2);
    }

    /**
     * 判断两个日期是否同一天.
     * 
     * @param ms1
     *            日期1
     * @param ms2
     *            日期2
     * @return 是否同一天
     */
    public static boolean isSameDay(Date d1, Date d2) {
        return isSameDay(d1.getTime(), d2.getTime());
    }
    /**
     * 将日期的long值除以一天的long值.
     * 
     * @param millis
     *            日期long值
     * @return 除后结果
     */
    private static long toDay(long millis) {
        int SECONDS_IN_DAY = 60 * 60 * 24;
        long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }
}
