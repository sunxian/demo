package com.example.demo.DesignPatttern;

import com.github.wxpay.sdk.WXPayXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunxian
 * @version 2022-06-06 17:20
 */
@Slf4j
public class SingletonPatternDemo {
    public static void main(String[] args) throws Exception {
        //Map<String, String> notifyMap =new HashMap<>();
        //notifyMap.put("out_trade_no","91097723310100122052811300006");

        Map<String, String> notifyMap = xmlToMap("<xml><appid><![CDATA[wx36be9aaebcb31b2b]]></appid>\n" +
                "<bank_type><![CDATA[OTHERS]]></bank_type>\n" +
                "<cash_fee><![CDATA[289860]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1509061481]]></mch_id>\n" +
                "<nonce_str><![CDATA[uvf9I8o4Koh7cMU32AK7qMquu9khT6WK]]></nonce_str>\n" +
                "<openid><![CDATA[oqsVZ1Hl_f1TsG0SUyYqFHVyQ0W0]]></openid>\n" +
                "<out_trade_no><![CDATA[91097723310100122052811300006]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[F423EC71305BD644FA416B71B96435C2]]></sign>\n" +
                "<time_end><![CDATA[20220528113041]]></time_end>\n" +
                "<total_fee>289860</total_fee>\n" +
                "<trade_type><![CDATA[APP]]></trade_type>\n" +
                "<transaction_id><![CDATA[4200001489202205280485235313]]></transaction_id>\n" +
                "</xml>");
        String orderNo = notifyMap.get("out_trade_no").split("o")[0];
        orderNo = orderNo.substring(orderNo.length() - 18, orderNo.length());
        String tradeNo = notifyMap.get("transaction_id");
        String tempFee = notifyMap.get("total_fee");
        String totalFee = new BigDecimal(tempFee).divide(new BigDecimal("100")).toString();

       log.info("微信支付回调解析参数：订单号" + orderNo + "，流水号" + tradeNo + "，支付金额" + totalFee);

    }

    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap();
            DocumentBuilder documentBuilder = WXPayXmlUtil.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for(int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == 1) {
                    Element element = (Element)node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }

            try {
                stream.close();
            } catch (Exception var9) {
            }

            return data;
        } catch (Exception var10) {
           // getLogger().warn("Invalid XML, can not convert to map. Error message: {}. XML content: {}", var10.getMessage(), strXML);
            throw var10;
        }
    }
}
