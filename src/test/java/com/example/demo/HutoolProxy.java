package com.example.demo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author sunxian
 * @version 2022-05-17 9:52
 */
public class HutoolProxy {

    static class ProxyAuthenticator extends Authenticator {
        private String user, password;

        public ProxyAuthenticator(String user, String password) {
            this.user     = user;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }


    final static String ProxyUser = "2582542870";
    final static String ProxyPass = "06chm7dd";

    // 代理IP、端口号
    final static String ProxyHost = "218.67.90.246";
    final static Integer ProxyPort = 15442;

    public static void main(String[] args) {
        // 目标网站
        String url = "https://www.510101.com/gsb/#/goodsHome";
        // JDK 8u111版本后，目标页面为HTTPS协议，启用proxy用户密码鉴权
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
    // System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "false");
      //  System.setProperty("jdk.http.auth.proxying.disabledSchemes", "false");
        // 设置请求验证信息
        Authenticator.setDefault(new ProxyAuthenticator(ProxyUser, ProxyPass));

        // 发送请求
        HttpResponse result = HttpRequest.get(url)
                .setHttpProxy(ProxyHost, ProxyPort)
                .timeout(20000)//设置超时，毫秒
                .execute();
        System.out.println(result.body());
    }
}
