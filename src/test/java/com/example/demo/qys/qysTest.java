package com.example.demo.qys;

import com.qiyuesuo.sdk.v2.SdkClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sunxian
 * @version 2022-10-09 14:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class qysTest {

    @Value("${qys.accessSecret}")
    private String accessSecret;
    @Value("${qys.accessKey}")
    private String accessKey;
    @Value("${qys.serverUrl}")
    private String serverUrl;

    @Test
    public  void test() {
        // 初始化sdkClient
       SdkClient sdkClient = new SdkClient(serverUrl, accessKey, accessSecret);
       log.info(accessSecret);
      // sdkClient.s
    }
}
