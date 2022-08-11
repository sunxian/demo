package com.example.demo.basic;

import cn.hutool.core.util.IdUtil;
import com.example.demo.entity.RequestDto;
import com.google.gson.*;
import dc.demo.DCHelper;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Base64;

import static com.example.demo.basic.CmbTest.UID;
import static dc.demo.DCHelper.getReqId;

/**
 * @author sunxian
 * @version 2022-07-26 13:16
 */
@Slf4j
public class cmbTtest1 {

   // private static String URL = "http://cdctest.cmburl.cn:80/cdcserver/api/v2"; // 银行服务地址(测试)
    private static String URL = "http://cdctest.cmburl.cn:80/cdcserver/api/v2"; // 银行服务地址(测试)
    private static String bankpubkey = "BNsIe9U0x8IeSe4h/dxUzVEz9pie0hDSfMRINRXc7s1UIXfkExnYECF4QqJ2SnHxLv3z/99gsfDQrQ6dzN5lZj0="; // 银行公钥

    private static String privkey = "NBtl7WnuUtA2v5FaebEkU0/Jj1IodLGT6lQqwkzmd2E=";
    private static String sm4key = "VuAzSWQhsoNqzn0K";//"1234567890123456"; // 用户的对称密钥

    private static java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
    private static java.util.Base64.Decoder decoder = Base64.getDecoder();

    private static final String ALG_SM = "SM"; // 采用国密算法

    //private static String UID = "N002466694"; // 测试的用户编号
   private static String UID = "N002466729"; // 测试的用户编号

    public static void main(String[] args) throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());

        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "DCLISMOD");
        head.addProperty("userid", UID);
        head.addProperty("reqid", dc.demo.DCHelper.getTime() + "0000001");
        body.addProperty("buscod", "N02030");
        body.addProperty("TEST", "中文");
        body.addProperty("TEST2", "!@#$%^&*()\\\\///");
        body.addProperty("TEST3", 12345);
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("arrItem1", "qaz");
        item.addProperty("arrItem2", 123);
        item.addProperty("arrItem3", true);
        item.addProperty("arrItem4", "中文");

        array.add(item);
        body.add("TEST4", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        doProcess(obj,"");
    }

    @Test
    public void test1() throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());

        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "NTDMAADD");
        head.addProperty("userid", UID);
        head.addProperty("reqid", dc.demo.DCHelper.getTime() + "0000001");
//        body.addProperty("buscod", "N02030");
//        body.addProperty("TEST", "中文");
//        body.addProperty("TEST2", "!@#$%^&*()\\\\///");
//        body.addProperty("TEST3", 12345);
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("accnbr", "755915704510123");
        item.addProperty("dmanbr", "1100010001");
        item.addProperty("dmanam", "2");


        array.add(item);
        body.add("ntdmaaddx", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        doProcess(obj,"");
    }

    @Test
    public void test22() throws Exception {
        int i=30;
        log.info(i%30+"");
    }

    //子账号查询
    @Test
    public void test2() throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());

        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "NTDMALST");
        head.addProperty("userid", UID);
        head.addProperty("reqid", dc.demo.DCHelper.getTime() + "0000001");
//        body.addProperty("buscod", "N02030");
//        body.addProperty("TEST", "中文");
//        body.addProperty("TEST2", "!@#$%^&*()\\\\///");
//        body.addProperty("TEST3", 12345);
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("accnbr", "755915704510123");
        item.addProperty("dmanbr", "0000059256");



        array.add(item);
        body.add("ntdmalstx", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        doProcess(obj,"NTDMALST");
    }


//    private static JsonObject getJsonObject() {
//        Map<String, List<Object>> body =new HashMap<>();
//        List<Object> items = new ArrayList<>();
//        Map<String, Object> item = new HashMap<>();
//        item.put("accnbr","755915704510123");
//        //记账子单元编号
//        item.put("dmanbr","0000059256");
//        //记账子单元名称
//        item.put("dmanam","59256");
//        items.add(item);
//        body.put("ntdmaaddx",items);
//       // RequestDto requestDto = new RequestDto();
//       // RequestDto.request request = requestDto.new request(body);
//       // requestDto.setRequest(request);
//        //RequestDto.head head = requestDto.new head("NTDMAADD",UID,dc.demo.DCHelper.getTime() + "0000001");
//        //requestDto.setHead(head);
//        Gson gson = new Gson();
//        String s = gson.toJson(requestDto);
//        JsonObject jsonObject = new JsonParser().parse(s).getAsJsonObject();
//        return jsonObject;
//    }


    public JsonObject getRequestObjectForTradeDetail(String accountNum)  {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "DCTRSINF");
        head.addProperty("userid", UID);
        head.addProperty("reqid", DCHelper.getReqId());
        //JsonArray array = new JsonArray();
        //JsonObject item = new JsonObject();
        //账号
        body.addProperty("bbknbr", "69");
        //item.addProperty("accnbr", "755915704510123");
        body.addProperty("accnbr", accountNum);
        body.addProperty("trsdat", "20220802");
        // array.add(item);
        // body.add("ntdmaaddx", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

    /**
     * 企银批量支付明细查询BB1QRYBD
     * @return
     * @throws Exception
     */
    public JsonObject getRequestForMultiPayResult(String functionName) throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", functionName);
        head.addProperty("userid", UID);
        head.addProperty("reqid", dc.demo.DCHelper.getTime() + "0000001");
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        //body.addProperty("bbknbr", "69");
        item.addProperty("bthNbr", "22072916560001");
         array.add(item);
         body.add("bb1qrybdy1", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }


    public JsonObject queryPayResultByYurRef(String yurRef,String functionCode) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", functionCode);
        head.addProperty("userid", UID);
        head.addProperty("reqid", getReqId());
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("busCod", "N02030");
        //item.addProperty("accnbr", "755915704510123");
        item.addProperty("yurRef", yurRef);
         array.add(item);
        body.add("bb1payqrx1", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

    public JsonObject queryBatchPayResulk(String functionCode) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", functionCode);
        head.addProperty("userid", UID);
        head.addProperty("reqid", getReqId());
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("begDat", "20220807");
        //item.addProperty("accnbr", "755915704510123");
        item.addProperty("endDat", "20220808");
        array.add(item);
        body.add("bb1qrybtx1", array);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

  //单笔经办
    public JsonObject createSingleBankPay() throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "BB1PAYOP");
        head.addProperty("userid", UID);
        head.addProperty("reqid", getReqId());
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
        payItem.addProperty("crtAcc", "7559157045101230000059256");
       // payItem.addProperty("dmaNbr", "0000059256");
        //收方户名
        payItem.addProperty("crtNam", "企业网银新20161346");
        //收方开户行名称
        payItem.addProperty("crtBnk", "招商银行深圳分行");
        //转出帐号
        payItem.addProperty("dbtAcc", "755915704510626");
        payItem.addProperty("nusAge", "测试");
        payItem.addProperty("trsAmt", "66.66");
        payItem.addProperty("yurRef", "202208020000000003");
        payItem.addProperty("bnkFlg", "Y");


        payArray.add(payItem);
        body.add("bb1payopx1", payArray);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

    public JsonObject createBankPay() throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("funcode", "BB1PAYBH");
        head.addProperty("userid", UID);
        head.addProperty("reqid", dc.demo.DCHelper.getTime() + "0000001");
        JsonArray array = new JsonArray();
        JsonObject item = new JsonObject();
       // cmb.bank.account.buscod=N02030
        //cmb.bank.account.busmod=00001
        item.addProperty("busCod", "N02030");
        item.addProperty("busMod", "00001");
        //批次编号
        item.addProperty("bthNbr", "gpyh07");
        //明细笔数
        item.addProperty("dtlNbr", "2");
        item.addProperty("ctnFlg", "N");
        array.add(item);
        body.add("bb1bmdbhx1", array);
        JsonArray payArray = new JsonArray();
        JsonObject payItem = new JsonObject();
        payItem.addProperty("ccyNbr", "10");
        //收方帐号
        payItem.addProperty("crtAcc", "755915704510626");
        //收方户名
        payItem.addProperty("crtNam", "59256");
        //转出帐号
        payItem.addProperty("dbtAcc", "755915704510123");
        payItem.addProperty("nusAge", "1");
        payItem.addProperty("trsAmt", "1.52");
        payItem.addProperty("yurRef", "202008260078000033");
        payItem.addProperty("bnkFlg", "Y");

        JsonObject payItem1 = new JsonObject();
        payItem1.addProperty("ccyNbr", "10");
        //收方帐号
        payItem1.addProperty("crtAcc", "6225880280120199");
        //收方户名
        payItem1.addProperty("crtNam", "中国工商银行总行清算中心");
        //转出帐号
        payItem1.addProperty("dbtAcc", "755915704510123");
        payItem1.addProperty("nusAge", "1");
        payItem1.addProperty("trsAmt", "1.53");
        payItem1.addProperty("yurRef", "202008260078000040");
        payItem1.addProperty("bnkFlg", "Y");
        payArray.add(payItem);
        payArray.add(payItem1);
        body.add("bb1paybhx1", payArray);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);
        // 请求发送接收
        return obj;
    }

    @Test
    public void testTradeDetail() {


        // 请求发送接收
        try {
            JsonObject result=doProcess(getRequestObjectForTradeDetail("755915704510123"),"DCTRSINF");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            log.error("sssssd");
        }
        // processTradeDetail(result,"111111");
    }

    @Test
    public void testMultiTransfer()throws Exception {
        // 引入BC库
        // Security.addProvider(new BouncyCastleProvider());
        JsonObject bankPay = createBankPay();

        // 请求发送接收
        JsonObject result=doProcess(createBankPay(),"BB1PAYBH");
        log.info("ssss");
        //processTradeDetail(result,"111111");
    }

    @Test
    public void testSingleTransfer()throws Exception {
        // 引入BC库
        // Security.addProvider(new BouncyCastleProvider());
        JsonObject bankPay = createBankPay();

        // 请求发送接收
        JsonObject result=doProcess(createSingleBankPay(),"BB1PAYOP");
        log.info("ssss");
        processSinglePay(result);
        //processTradeDetail(result,"111111");
    }

    @Test
    public void getReqid()  {
        // 引入BC库
        String s = DCHelper.getTime()  + IdUtil.simpleUUID();
        log.info(s);
        log.info(s.length()+"");
        log.info("jdk: {}", UUID.randomUUID());


        //getTime();
        //processTradeDetail(result,"111111");
    }

    void getTime( ) throws  Exception{
        log.info("sss");
    }



    /**
     * 批次整体失败 无法通过流程后查到所有
     * @throws Exception
     */
    @Test
    public void singlePayResult()throws Exception {
        // 引入BC库
        // Security.addProvider(new BouncyCastleProvider());
        // 请求发送接收
        //for (int i=0;i<3;i++) {
            JsonObject result = doProcess(queryPayResultByYurRef("20220808101715163", "BB1PAYQR"), "BB1PAYQR");

       // }

    }

    @Test
    public void BatchPayresult()throws Exception {
        // 引入BC库
        // Security.addProvider(new BouncyCastleProvider());
        // 请求发送接收
        //for (int i=0;i<3;i++) {
        JsonObject result = doProcess(queryBatchPayResulk( "BB1QRYBT"), "BB1QRYBT");

        // }

    }


    void processSinglePay(JsonObject result){
        JsonObject response = result.get("response").getAsJsonObject();
        JsonObject head = response.get("head").getAsJsonObject();
        JsonObject body = response.get("body").getAsJsonObject();
        JsonArray bb1payopz1 = body.get("bb1payopz1").getAsJsonArray();
        JsonObject resultItem = bb1payopz1.get(0).getAsJsonObject();

        String resultcode = head.get("resultcode").getAsString();
        //流程实例号
        String reqNbr = resultItem.get("reqNbr").getAsString();
        if (resultcode.equals("SUC0000")) {
            if("SUC0000".equals(resultItem.get("errCod").getAsString())){
                //请求成功
                log.info("请求成功");
            }else {
                String msgTxt = resultItem.get("msgTxt").getAsString();
                log.info(msgTxt);
            }
            //请求状态
            String reqSts = resultItem.get("reqSts").getAsString();
            /**
             *
             reqSts =’FIN’时，rtnFlg才有意义；
             reqSts =’FIN’并且RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理。
             返回结果：
             S	成功	银行支付成功
             F	失败	银行支付失败
             B	退票	银行支付被退票
             R	否决	企业审批否决
             D	过期	企业过期不审批
             C	撤消	企业撤销
             U	银行挂账
             */
            if("FIN".equals(reqSts)){

            }
        }

    }
    @Test
    public void testMultiPayResult()throws Exception {
        // 引入BC库
        // Security.addProvider(new BouncyCastleProvider());
        //JsonObject bankPay = createBankPay();

        // 请求发送接收
        JsonObject result=doProcess(getRequestForMultiPayResult("BB1QRYBD"),"BB1QRYBD");
        log.info("ssss");
        //processTradeDetail(result,"111111");
    }


    private void processTradeDetail(JsonObject result,String accountNum) {
        JsonObject response = result.get("response").getAsJsonObject();
        JsonObject head = response.get("head").getAsJsonObject();
        String resultcode = head.get("resultcode").getAsString();
        if (resultcode.equals("SUC0000")){
            JsonObject body = response.get("body").getAsJsonObject();
            JsonArray ntqactrsz2 = body.getAsJsonArray("ntqactrsz2");
            Iterator<JsonElement> iterator = ntqactrsz2.iterator();
            while (iterator.hasNext()){
                JsonObject jsonObject = (JsonObject)iterator.next();
                //借贷标记
                String loanMark = getString(jsonObject,"amtcdr");
                String haveAnnex = getString(jsonObject,"athflg");
                //分行号
                String bbknbr = getString(jsonObject,"bbknbr");
                //业务名称
                String businessName =getString(jsonObject,"busnam");
                String tradeDate = getString(jsonObject,"etydat");
                String tradeTime = getString(jsonObject,"etytim");
                //信息标志
                String infflg = getString(jsonObject,"infflg");
                //扩展摘要
                String summaryPlus =getString(jsonObject,"narext");
                String summary = getString(jsonObject,"naryur");jsonObject.get("naryur").getAsString();
                //流水号
                String voucherNum =getString(jsonObject,"refnbr");
                //商务支付订单号
                String businessOrderCode =getString(jsonObject,"refsub");
                //流程实例号
                String processInstanceNum =getString(jsonObject,"reqnbr");
                //收/付方帐号
                String payerAccountNum = getString(jsonObject,"rpyacc");
                String payerOpenBankAddress = getString(jsonObject,"rpyadr");
                String payerOpenBankName = getString(jsonObject,"rpybnk");
                String payerAccountName =getString(jsonObject,"rpynam");
                //String rsv30z = jsonObject.get("rsv30z").getAsString();
                //交易金额
                BigDecimal trsamt =getNum(jsonObject,"trsamt");
                //交易分析码
                String tradeAnalysisCode = getString(jsonObject,"trsanl");
                //余额
                BigDecimal balanceAmount = getNum(jsonObject,"trsblv");
                String tradeType = getString(jsonObject,"trscod");
                String valueDate = getString(jsonObject,"vltdat");
                //业务参考号
                String businessReferenceNum = getString(jsonObject,"yurref");
                String subCompanyArea = getString(jsonObject,"gsbbbk");
                String subCompanyAccountNum = getString(jsonObject,"gsbacc");
                String subCompanyName =getString(jsonObject,"gsbnam");
                String use = getString(jsonObject,"nusage");
                //开通收方识别功能的账户可以通过此码识别付款方
                String customerIdentificationCode = getString(jsonObject,"frmcod");
                //票据号
                String billNum = getString(jsonObject,"chknbr");
                String businessSummary = getString(jsonObject,"busnar");
                String redMark = getString(jsonObject,"rsvflg");
                String payerOpenAccountRegion = getString(jsonObject,"rpybbk");

                log.info("交易金额 "+trsamt+"");
                log.info(payerAccountNum+"");

            }
        }

    }



    private String getString(JsonObject jsonObject, String name) {
        if (jsonObject.get(name) == null) {
            return null;
        } else {
            return jsonObject.get(name).getAsString();
        }
    }

    private BigDecimal getNum(JsonObject jsonObject, String name) {
        if (jsonObject.get(name) == null) {
            return null;
        } else {
            return jsonObject.get(name).getAsBigDecimal();
        }
    }



    @Test
    public void testAddAccount()throws Exception {
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());

        // 请求发送接收
        //doProcess(getJsonObject(),"DCTRSINF");
    }

    private static JsonObject doProcess(JsonObject jObject,String function) throws Exception {
        JsonObject object = new JsonObject();
        // 签名
        object.addProperty("sigdat", "__signature_sigdat__");
        object.addProperty("sigtim", dc.demo.DCHelper.getTime());
        jObject.add("signature", object);
        String source = dc.demo.DCHelper.serialJsonOrdered(jObject);
        System.out.println("签名原文: " + source);
        byte[] signature1 = dc.demo.DCCryptor.CMBSM2SignWithSM3(getID_IV(), decoder.decode(privkey), source.getBytes(StandardCharsets.UTF_8));
        String sigdat1 = new String(encoder.encode(signature1));
        System.out.println("签名结果: " + sigdat1);
        object.addProperty("sigdat", sigdat1);

        // SM4-CBC加密
        String plaintxt = jObject.toString();
        System.out.println("加密前req:  " + plaintxt);
        byte[] enInput = dc.demo.DCCryptor.CMBSM4EncryptWithCBC(sm4key.getBytes(), getID_IV(), plaintxt.getBytes(StandardCharsets.UTF_8));

        String req = new String(encoder.encode(enInput));
        System.out.println("加密后req:  " + req);

        // 发送请求
        HashMap<String, String> map = new HashMap<>();
        map.put("UID", UID);
        map.put("ALG", ALG_SM);
        map.put("DATA", URLEncoder.encode(req, "utf-8"));
        map.put("FUNCODE", function);
        String res = dc.demo.DCHelper.doPostForm(URL, map);
        System.out.println("res:  " + res);
       try {
            decoder.decode(res);
       } catch (Exception e) {
            System.err.println("访问返回错误.");
            return null;
       }

        // 解密请求
        String resplain = new String(dc.demo.DCCryptor.CMBSM4DecryptWithCBC(sm4key.getBytes(), getID_IV(), decoder.decode(res)), StandardCharsets.UTF_8);
        System.out.println("res decrypt: " + resplain);

        // 验签
        JsonObject object2 = new GsonBuilder().create().fromJson(resplain, JsonObject.class);
        JsonObject object3 = object2.getAsJsonObject("signature");
        String resSign = object3.get("sigdat").getAsString();
        object3.addProperty("sigdat", "__signature_sigdat__");
        object2.add("signature", object3);
        String resSignSource = dc.demo.DCHelper.serialJsonOrdered(object2);
        System.out.println("验签原文: " + resSignSource);
        System.out.println("验签签名值: " + resSign);
        boolean verify = dc.demo.DCCryptor.CMBSM2VerifyWithSM3(getID_IV(), decoder.decode(bankpubkey), resSignSource.getBytes(StandardCharsets.UTF_8), decoder.decode(resSign));
        System.out.println("验签结果: " + verify);
        return object2;
    }

    private static byte[] getID_IV() {
        String uid = UID; // 请替换为实际的用户UID
        String userid = uid + "0000000000000000";
        return userid.substring(0, 16).getBytes();
    }

}
