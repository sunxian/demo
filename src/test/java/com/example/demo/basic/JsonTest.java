package com.example.demo.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.RequestDto;
import com.example.demo.entity.User;
import com.example.demo.util.HttpClientUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.basic.CmbTest.UID;

/**
 * @author sunxian
 * @version 2022-07-04 14:54
 */
@Slf4j
public class JsonTest {

   class Param{
      private Long gpGoodsId;

      private String sku;

      private String qty;

      private Long storeid;

      private Long memberid;

      public Long getGpGoodsId() {
         return gpGoodsId;
      }

      public void setGpGoodsId(Long gpGoodsId) {
         this.gpGoodsId = gpGoodsId;
      }

      public String getSku() {
         return sku;
      }

      public void setSku(String sku) {
         this.sku = sku;
      }

      public String getQty() {
         return qty;
      }

      public void setQty(String qty) {
         this.qty = qty;
      }

      public Long getStoreid() {
         return storeid;
      }

      public void setStoreid(Long storeid) {
         this.storeid = storeid;
      }

      public Long getMemberid() {
         return memberid;
      }

      public void setMemberid(Long memberid) {
         this.memberid = memberid;
      }
   }

   @Test
   public void t1(){
      User user = new User();

      user.setUsername("admin");
      user.setName("管");
      user.setId(1L);
      Param param = new Param();
      param.setGpGoodsId(719774L);
      param.setMemberid(28685L);
      param.setGpGoodsId(719774L);
      param.setStoreid(519L);
      param.setQty("0");
      param.setSku("720103");
      ArrayList<Object> params = new ArrayList<>();
      params.add(param);
      //log.info(JSONObject.toJSONString(params));
      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("goodsStockList", JSONObject.toJSONString(params));
      //String result = HttpClientUtil.sendPost("http://www.jinshang9.cn/jinshang-server/rest/callback/wms/productStore/updateStorenum/list", paramMap);
     // log.info(result);
      String s="abc";
      String substring = s.substring( 1,3);
      log.info(substring);
      char value[] = new char[3];
      String s1 = new String(value, 0, 1);
      //log.info();
   }

   @Test
   public void t2(){
      User user = new User();

      user.setUsername("admin");
      user.setName("管");
      user.setId(1L);
      Param param = new Param();
      param.setGpGoodsId(719774L);
      param.setMemberid(28685L);
      param.setGpGoodsId(719774L);
      param.setStoreid(519L);
      param.setQty("0");
      param.setSku("720103");
      ArrayList<Object> params = new ArrayList<>();
      params.add(param);
      //log.info(JSONObject.toJSONString(params));
      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("goodsStockList", JSONObject.toJSONString(params));
      //String result = HttpClientUtil.sendPost("http://www.jinshang9.cn/jinshang-server/rest/callback/wms/productStore/updateStorenum/list", paramMap);
      // log.info(result);
      String s="abc";
      String substring = s.substring( 1,3);
      log.info(substring);
      char value[] = new char[3];
      String s1 = new String(value, 0, 1);
      //log.info();
   }

   @Test
   public void getRequestStrForAdd() {
      Map<String, List<Object>> body =new HashMap<>();
      List<Object> items = new ArrayList<>();
      Map<String, Object> item = new HashMap<>();
      item.put("accnbr","769900019310827");
      //记账子单元编号
      item.put("dmanbr","sunxiantest");
      //记账子单元名称
      item.put("dmanam","记账子单元名称");
      items.add(item);
      body.put("ntdmaaddx",items);
      RequestDto requestDto = new RequestDto();
      RequestDto.request request = requestDto.new request(body);
      requestDto.setRequest(request);
      //RequestDto.head head = requestDto.new head("NTDMAADD","N000086168");
     // requestDto.setHead(head);
      String s = JSONObject.toJSONString(requestDto);
         log.info(s);

   }


}
