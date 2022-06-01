package com.example.demo.task;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sunxian
 * @version 2022-05-25 14:46
 */
@Slf4j
@Service
public class WriteLog {

    @Scheduled(cron = "0 0/10 * * * *")
    public void writeLog(){
        log.info("现在是 {} ",DateUtil.now());
    }
}
