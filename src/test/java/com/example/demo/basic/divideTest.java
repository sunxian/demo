package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author sunxian
 * @version 2022-06-28 11:31
 */
@Slf4j
public class divideTest {


    @Test
    void t1() {
        BigDecimal b1 = new BigDecimal(96);
        BigDecimal divide = b1.divide(new BigDecimal(30), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal divide1 = b1.divide(new BigDecimal(30), BigDecimal.ROUND_HALF_UP);
        log.info(divide.toString());
        log.info(divide1.toString());

        String s = "91310115741600185k";
        boolean taxCode = isTaxCode(s);
        log.info(taxCode + "");


    }

    public static boolean isTaxCode(String str) {
        String rule = "^[0-9A-HJ-NPQRTUWXY]{2}\\d{6}[0-9A-HJ-NPQRTUWXY]{10}$";
        return str.matches(rule);
    }
}
