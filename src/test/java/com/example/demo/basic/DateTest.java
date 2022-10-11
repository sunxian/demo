package com.example.demo.basic;

import com.example.demo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author sunxian
 * @version 2022-09-06 14:29
 */
@Slf4j
public class DateTest {

    @Test
    public void t1(){


        String ssss = String.format("月结30天使用期间的逾期次数大于3次，无法升至%s", "ssss");
        log.info(ssss);

        int day = DateUtils.getDay(new Date());
        Integer maxDay = DateUtils.getDay(new Date());
        String deliveryDate = getDeliveryDate(day);
        log.info(deliveryDate);
    }

    public String getDeliveryDate(int riqi) {
        Calendar ca = Calendar.getInstance();
        String year = ca.get(Calendar.YEAR) + "";// 获取年份
        String month = (ca.get(Calendar.MONTH) + 1) + "";// 获取月份
        String day = riqi + "";// 获取日
        String now = year + "-" + month + "-" + day;
        return now;
    }




}
