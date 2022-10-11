package com.example.demo.controller;

import com.example.demo.anotation.Log;
import com.example.demo.anotation.RequestLog;
import com.example.demo.entity.User;
import com.example.demo.service.OrderService;
import com.example.demo.util.DCCryptor;
import com.example.demo.util.DCHelper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.*;

/**
 * @author sunxian
 * @version 2022-05-25 15:06
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private OrderService orderService;

    private static String URL = "http://cdctest.cmburl.cn:80/cdcserver/api/v2"; // 银行服务地址(测试)
    private static String bankpubkey = "BNsIe9U0x8IeSe4h/dxUzVEz9pie0hDSfMRINRXc7s1UIXfkExnYECF4QqJ2SnHxLv3z/99gsfDQrQ6dzN5lZj0="; // 银行公钥

    private static String privkey = "NBtl7WnuUtA2v5FaebEkU0/Jj1IodLGT6lQqwkzmd2E=";
    private static String sm4key = "VuAzSWQhsoNqzn0K";//"1234567890123456"; // 用户的对称密钥

    private static java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
    private static java.util.Base64.Decoder decoder = Base64.getDecoder();

    private static final String ALG_SM = "SM"; // 采用国密算法

    //private static String UID = "N002466694"; // 测试的用户编号
    private static String UID = "N002466694"; // 测试的用户编号


    @RequestMapping("test")
    public  String  healthCheck(@RequestParam(value = "text",required = false) String text){
        if(text!=null){
            log.info("接收到 {}",text);
        }
        return "success";
    };

    @RequestMapping("testXiaofeng")
    @RequestLog(value = 1)
    public  String  testXiaofeng(){

        orderService.placeAnOrder();
        return "success";
    };

    @RequestMapping("test2")
    public  String  testXiaofeng1(User u){

        return "success";
    };

    @RequestMapping("test1")
    public  String  t1(){
        Map<String, Object> rm = new HashMap<>();
        try {
            orderService.createOrder(1);
        } catch (RuntimeException e) {
            e.printStackTrace();
            rm.put("r",false);
            if(e.getMessage().getBytes().length == e.getMessage().length()) {
                log.info("发送");
            }
        }catch (Exception e) {
           log.info("22222");
        }
        return "success";
    };

    @RequestMapping("transferA")
    public  String  transferAmount(String account,String amount){
        
        try {
          doProcess(transfer(account,amount),"BB1PAYOP");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return "success";
    };


    @RequestMapping("testOOM")
    public  String  testOOM(Long i){
       if (i!=null){
           for (int j = 0; j <i ; j++) {
               User user = new User();
           }
       }

//        List<byte[]> list = new ArrayList<>();
//
//        while (true) {
//            list.add(new byte[1024 * 1024]); // 每次增加一个1M大小的数组对象
//        }
return "ss";
    };

    @RequestMapping("gc")
    public  void   testGc(){
         final int _1MB = 1024 * 1024;

            System.out.println("0.---");

            List caches = new ArrayList();

            for (int i = 0; i < 11; i++){
                caches.add(new byte[3 * _1MB]);
            }

            System.out.println("1.---");

            caches.add(new byte[3 * _1MB]);

            caches.remove(0);
            caches.add(new byte[3 * _1MB]);


            for (int i = 0; i < 8; i++) {
                caches.remove(0);
            }
            caches.add(new byte[3 * _1MB]);

            System.out.println("2.---");

            for (int i = 0; i < 7; i++){
                caches.add(new byte[3 * _1MB]);
            }

    };


    @RequestMapping("gc1")
    public  void   testGc1(){
       System.gc();
    };

    //单笔经办
    public JsonObject transfer(String account,String amount) throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "BB1PAYOP");
        head.addProperty("userid", "N002466694");
        head.addProperty("reqid", DCHelper.getReqId());
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        // cmb.bank.account.buscod=N02030
        //cmb.bank.account.busmod=00001
        item.addProperty("busCod", "N02030");
        item.addProperty("busMod", "00002");
        array.add(item);
        body.add("bb1paybmx1", array);
        JsonArray payArray = new JsonArray();
        JsonObject payItem = new JsonObject();
        payItem.addProperty("ccyNbr", "10");
        //收方帐号
        payItem.addProperty("crtAcc", account);
        // payItem.addProperty("dmaNbr", "0000059256");
        //收方户名
        payItem.addProperty("crtNam", "企业网银新20161346");
        //收方开户行名称
        payItem.addProperty("crtBnk", "招商银行深圳分行");
        //转出帐号
        payItem.addProperty("dbtAcc", "755915704510626");
        payItem.addProperty("nusAge", "测试");
        payItem.addProperty("trsAmt", amount);
        payItem.addProperty("yurRef", DCHelper.getMillTime()+"");
        payItem.addProperty("bnkFlg", "Y");
        payArray.add(payItem);
        body.add("bb1payopx1", payArray);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

    private static JsonObject doProcess(JsonObject jObject, String functionName) throws Exception {
        JsonObject object = new JsonObject();
        // 签名
        object.addProperty("sigdat", "__signature_sigdat__");
        object.addProperty("sigtim", DCHelper.getTime());
        jObject.add("signature", object);
        String source = DCHelper.serialJsonOrdered(jObject);
        log.info("签名原文: " + source);
        byte[] signature1 = DCCryptor.CMBSM2SignWithSM3(getID_IV(), decoder.decode(privkey), source.getBytes(StandardCharsets.UTF_8));
        String sigdat1 = new String(encoder.encode(signature1));
        log.info("签名结果: " + sigdat1);
        object.addProperty("sigdat", sigdat1);

        // SM4-CBC加密
        String plaintxt = jObject.toString();
        log.info("加密前req:  " + plaintxt);
        byte[] enInput = DCCryptor.CMBSM4EncryptWithCBC(sm4key.getBytes(), getID_IV(), plaintxt.getBytes(StandardCharsets.UTF_8));

        String req = new String(encoder.encode(enInput));
        log.info("加密后req:  " + req);

        // 发送请求
        HashMap<String, String> map = new HashMap<>();
        map.put("UID", UID);
        map.put("ALG", ALG_SM);
        map.put("DATA", URLEncoder.encode(req, "utf-8"));
        map.put("FUNCODE", functionName);
        String res = DCHelper.doPostForm(URL, map);
        log.info("res:  " + res);
        decoder.decode(res);
        // 解密请求
        String resplain = new String(DCCryptor.CMBSM4DecryptWithCBC(sm4key.getBytes(), getID_IV(), decoder.decode(res)), StandardCharsets.UTF_8);
        log.info("res decrypt: " + resplain);

        // 验签
        JsonObject object2 = new GsonBuilder().create().fromJson(resplain, JsonObject.class);
        JsonObject object3 = object2.getAsJsonObject("signature");
        String resSign = object3.get("sigdat").getAsString();
        object3.addProperty("sigdat", "__signature_sigdat__");
        object2.add("signature", object3);
        String resSignSource = DCHelper.serialJsonOrdered(object2);
        log.info("验签原文: " + resSignSource);
        log.info("验签签名值: " + resSign);
        boolean verify = DCCryptor.CMBSM2VerifyWithSM3(getID_IV(), decoder.decode(bankpubkey), resSignSource.getBytes(StandardCharsets.UTF_8), decoder.decode(resSign));
        log.info("验签结果: " + verify);
        return object2;
    }

    private static byte[] getID_IV() {
        String uid = UID; // 请替换为实际的用户UID
        String userid = uid + "0000000000000000";
        return userid.substring(0, 16).getBytes();
    }

}
