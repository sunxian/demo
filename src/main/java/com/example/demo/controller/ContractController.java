package com.example.demo.controller;

import com.qiyuesuo.sdk.v2.SdkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxian
 * @version 2022-10-09 14:13
 */
@RestController
public class ContractController {


@Value("${qiyuesuo.accessSecret}")
    private String accessSecret;
    @Value("${qiyuesuo.accessKey}")
    private String accessKey;
    @Value("${qiyuesuo.serverUrl}")
    private String serverUrl;
    public  void test() {
        // 初始化sdkClient
       // SdkClient sdkClient = new SdkClient(serverUrl, accessKey, accessSecret);
    }
}
