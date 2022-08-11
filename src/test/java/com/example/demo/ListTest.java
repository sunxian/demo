package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunxian
 * @version 2022-05-06 16:14
 */
@Slf4j
public class ListTest {

    @Test
    void sysss(){
        List<Long> objects = new ArrayList<>();
        List<Long> objects1 = new ArrayList<>();
        objects.add(1L);
       objects1.add(3L);
       objects1.add(4L);
        objects1.removeAll(objects);
        objects1.addAll(objects);
        log.info("ssss");
        objects1.forEach(i->log.info(i+""));


    }

    @Test
    void user1(){
        Date supplierShouldPayDate = getSupplierShouldPayDate(DateUtils.formatDate("2022-07-20"), "010002");
        log.info(DateUtils.fmtDate(supplierShouldPayDate));
    }


    public Date getSupplierShouldPayDate(Date invoiceDate, String  dictDto) {
        if (dictDto.equals("010001")) {
            return invoiceDate;
        }

        int addDay = 28;
        int month = 0;

        String settleDes = "月结35";
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(settleDes);

        String dayStr = m.replaceAll("");

        if (StringUtils.isNotEmpty(dayStr)) {
            int day = Integer.valueOf(dayStr);

            month = (day / 30) + 1;
            addDay = day % 30;

            if (addDay == 0) {
                addDay = 28;
                month --;
            }
        }

        return DateUtils.getAfterDay(DateUtils.getBeforeMonth(DateUtils.getFirstDayOfMonth(invoiceDate), -month), addDay - 1);
    }
}
