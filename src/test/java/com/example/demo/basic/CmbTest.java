package com.example.demo.basic;

import com.example.demo.entity.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sunxian
 * @version 2022-07-26 10:53
 */
@Slf4j
public class CmbTest {
    // static String pubkeyStr =
    // "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1H0QOizFZfBObFLVCImZi6RvPezNgPDXfYOpgjCPUNlypP1r77Q4nH58OcKVUh6YvAbxEjX9W1B8269w6IFS36QnztUy9kA+ByD2Iq9ik+WpwR0+HXWukaBGIvCYnSBOuVW97Kd/h646buXTNOtm49ywMd/Tq3rF+S2CKd/vO4xrsEWBu3z4owLJQh3lrza6zZqUslI8YOLftQhEBAOkg0gpszC3V3XCihGdHA9FIbEZksH3aQ6Mkq6qpjfS22ESFl4Hm7UIWyAsSn04ZsE2lkRHF2rgNr7oNXoDSYTni/zqLLiCzp+QUvkcXNL2L0IayAVoWHAicM9ZrFYV900+qwIDAQAB";
    // static String prikeyStr =
    // "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDUfRA6LMVl8E5sUtUIiZmLpG897M2A8Nd9g6mCMI9Q2XKk/WvvtDicfnw5wpVSHpi8BvESNf1bUHzbr3DogVLfpCfO1TL2QD4HIPYir2KT5anBHT4dda6RoEYi8JidIE65Vb3sp3+Hrjpu5dM062bj3LAx39OresX5LYIp3+87jGuwRYG7fPijAslCHeWvNrrNmpSyUjxg4t+1CEQEA6SDSCmzMLdXdcKKEZ0cD0UhsRmSwfdpDoySrqqmN9LbYRIWXgebtQhbICxKfThmwTaWREcXauA2vug1egNJhOeL/OosuILOn5BS+Rxc0vYvQhrIBWhYcCJwz1msVhX3TT6rAgMBAAECggEAaG/LkPw+TTsOIHmZ0SdoO1Ung8UmwDAficYzgxSA7BjkGymfamImzOvx/KWhpIn7Qbcbt3qnusDVjVguY2hkphzVn/fzo0qx8ekGcMfI6K4hgBPyWqJjmZmvvy6Ho/qkFr2Iqo8sxDAi8iytYT4uBOKMCwdaztZ6BV2TsycoOxiEmRVjW9uXye+OCy6DCanmwhG9wRKIppyCB7bpmtoEorHsrZEsdxHEE00dtFmWgOJF3aIgmC0e0AbSTXddplEuSj3KOogH1xyIzyUVs1vTVOZUJ5Z4DLUvn7cN1up/woO9t9opAwpyjztA+DtLuuZNRvDf/b0U7bX8E27U95NlEQKBgQD2pb2e/KcwNHHNPlzRmVKAphgIH/WwMVDZz0/IN8zfJS9/DcKSpjtUhlbd2qx3ZkT+e7Feay38wiIr41wSD6aB7+Um3pD1EUY4/XrXBL5na37whHBwkd+WwVBtUiFGxIko7+qrfNG+TZZKlxIZU6G+A8oYft+zNP7ElSXkxGbVIwKBgQDci7wnTrHk9674iy1Eb/I6O+pYmpfKip/vJkmQfLeW9LTv6+cbAJNAPGLpBC3fsqhqBr+cHNnq7LnXbiG5Cp6TJKbLnI/JQWh1mKOzsUzJtZIDHfoMr+bXh82zAdJZPBhU8Fli1H2XtEIpQXiy6LEne+IuH5LwzhEuoHnKq+5c2QKBgAC81ihXkRhvz7dRbG2kC78ewAumLNHuE9PS7uYmZJJ2RgIXRHGz1ZGXJUNcmA9zWtl3/TvPDkAnRHrlHy1eppzU3taS69QPzSn2eBuUhA1DIQoPG1b62LRWt6rcCAVyKQbaUNVadjYffUeT1BYHTgCHel9AYeLjUa+80nQwsi4JAoGAfFkQ+fyl0ppP/fTCzh5sLadQhyqKwPkOGdG1kpCvFp7cUZXplNDrNUGW5xijIMhjqnwplsSxnYJhefSvcNxq8j2tCYo5i9ikJAGu8wbZa7VDIRzKulKHTihUs0QorIV0lpd5Xn6+XUWWNBqlCgKmt8NikGze9YTKLUbvxHTSDWkCgYAc+LAkPk7evqDvCkQ5FpNTkV7fNMJ44lt/zsTvbYqohuMaiNlF1k4HuX+e+SgCy/s2PaZkUfdz/qBZCqmVohlmYladuIMZP/S4/PER/K34QyPXZo01lRUlGsfMSrNrU5fcT+C0270CAr4P40grlst2ndq3M4Dxzpq56FEb/uNLUQ==";
    static String pubkeyStr = "BOW/Y31ls9x56aOJpIIePBOBtw4QCmMxsNukUewBD1y6ayy9b+KyVHBvb7UvVxEnmQD+ywbQB2bYG9SeCfefCIc=";
    static String prikeyStr = "Qk5zSWU5VTB4OEllU2U0aC9keFV6VkV6OXBpZTBoRFNmTVJJTlJYYzdzMVVJWGZrRXhuWUVDRjRRcUoyU25IeEx2M3ovOTlnc2ZEUXJRNmR6TjVsWmowPQ==";

    private static PrivateKey privateKey;
    private static PublicKey publicKey;
    static String UID = "N002466694";
    //static String URL = "http://99.11.2.154:8080/cdcserver/api/v2";
   //static String URL = "http://183.62.66.60:9080/cdcserver/api/v2";
   static String URL = "http://99.12.250.6:9080/cdcserver/api/v2";

    //static String data = "{\"request\": { \"head\": {\"funcode\": \"DCDACCYE\",  \"userid\": \"Y100022681\",   \"reqid\": \"2020061910001123456780001fbdev01\"  },      \"body\": {        }    }}";
    static String data="{\"request\":{\"body\":{\"ntdmaaddx\":[{\"accnbr\":\"755915707610308\",\"bcktyp\":\"N\",\"clstyp\":\"N\",\"dmanam\":\"记账子单元测试\",\"dmanbr\":\"1056184113\",\"ovrctl\":\"N\"}]},\"head\":{\"funcode\":\"NTDMAADD\",\"reqid\":\"202103021528582239a034966327\",\"userid\":\"N002985759\"}}}";

    static String AESKEY = "VuAzSWQhsoNqzn0K";

    public static void main(String[] args) {

        try {
            init();
            JSONObject object = getJsonObject();
            DoProcess(object, privateKey);
            log.info("成功！！！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getJsonObject() {
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
        //RequestDto.head head = requestDto.new head("NTDMAADD","N000086168",);
        //requestDto.setHead(head);
        String s = com.alibaba.fastjson.JSONObject.toJSONString(requestDto);
        JSONObject object = new JSONObject(s);
        return object;
    }

    public static void init() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        publicKey = getPublicKeyFromBytes(pubkeyStr);
        privateKey = getPrivateKeyFromBytes(prikeyStr, "PKCS");
    }

    public static String DoProcess(JSONObject jObject, PrivateKey prikey) throws Exception {
        JSONObject object = new JSONObject();
        // 签名
        object.put("sigdat", "__signature_sigdat__");
        // object.put("sigtim", GetTime());

        object.put("sigtim",  GetTime());
        jObject.put("signature", object);
        String source = serialJsonOrdered(jObject);
        System.out.println(source);
        String data = signRsa2048(source.getBytes());
        object.put("sigdat", data);
        jObject.put("signature", object);

        // AES加密
        String AesPlainxt = serialJsonOrdered(jObject);
        System.out.println("加密前req:  " + AesPlainxt);
        String req = encryptAES256Str(AesPlainxt, AESKEY.getBytes());
        System.out.println("加密后req:  " + req);

        // 发送请求
        HashMap<String, String> map = new HashMap<>();
        map.put("UID", UID);
        map.put("DATA", URLEncoder.encode(req, "utf-8"));
        String res = doPostForm(URL, map);
        System.out.println("res:  " + res);

        // 解密请求
        String resplain = decryptAES256(res, AESKEY.getBytes(), true);
        System.out.println("res decrypt: " + resplain);
        JSONObject object2 = new JSONObject(resplain);
        JSONObject object3 = object2.getJSONObject("signature");
        String resSign = object3.getString("sigdat");
        object3.put("sigdat", "__signature_sigdat__");
        object2.put("signature", object3);
        String resSignSource = serialJsonOrdered(object2);
        System.out.println("验签原文: " + resSignSource);
        System.out.println("验签签名值: " + resSign);
        Boolean verify = signRsa2048Verify(resSignSource.getBytes(), Base64.decode(resSign), publicKey);
        System.out.println("验签结果: " + verify);
        return "";
    }

    public static String GetTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }

    public static String encryptAES256Str(String content, byte[] bytePassword) {
        return Base64.encode(encryptAES256(content, bytePassword));
    }

    public static byte[] encryptAES256(String content, byte[] bytePassword) {
        try {
            Cipher cipherInstance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(bytePassword, "AES");
            cipherInstance.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes();
            byte[] cryptograph = cipherInstance.doFinal(byteContent);
            return cryptograph;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bytePassword;
    }

    public static String decryptAES256(String content, byte[] bytePassword, boolean logError) {
        if (content == null || content.length() == 0) {
            System.out.println("解密失败1");
        }
        byte[] bContent = null;
        try {
            bContent = Base64.decode(content);
        } catch (Exception e) {
            System.out.println("解密失败2");
            e.printStackTrace();
        }
        try {
            Cipher cipherInstance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(bytePassword, "AES");
            cipherInstance.init(Cipher.DECRYPT_MODE, key);
            byte[] crypted = cipherInstance.doFinal(bContent);
            return new String(crypted, "utf-8");
        } catch (Exception e) {
            System.out.println("解密失败3" + e.getMessage());
        }
        return content;
    }

    //RSA 2048 签名
    public static String signRsa2048(byte[] baSource) throws Exception {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(privateKey);
            signature.update(baSource);
            return Base64.encode(signature.sign());
        } catch (Exception e) {
            System.out.println("签名失败" + e.getMessage());
            throw new Exception("签名失败" + e.getMessage());
        }
    }

    public static String signRsa2048(byte[] baSource, PrivateKey prvKey) throws Exception {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(prvKey);
            signature.update(baSource);
            return Base64.encode(signature.sign());
        } catch (Exception e) {
            System.out.println("签名失败" + e.getMessage());
            throw new Exception("签名失败 " + e.getMessage());
        }
    }

    public static boolean signRsa2048Verify(byte[] baSource, byte[] baSignature, PublicKey pubKey) throws Exception {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            signature.update(baSource);
            return signature.verify(baSignature);
        } catch (Exception e) {
            System.out.println("验签失败 " + e.getMessage());
            throw new Exception("验签失败 " + e.getMessage());
        }
    }

    //
    public static PrivateKey getPrivateKeyFromBytes(String crtBase64, String type) throws Exception {
        // type = PKCS,X509
        try {
            byte[] baKey = Base64.decode(crtBase64);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey prvkey = keyFactory.generatePrivate(type.equals("PKCS") ? new PKCS8EncodedKeySpec(baKey) : new X509EncodedKeySpec(baKey));
            return prvkey;
        } catch (Exception e) {
            throw new Exception("读取私钥失败" + e.getMessage());
        }
    }

    //
    public static PublicKey getPublicKeyFromBytes(String crtBase64) throws Exception {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(crtBase64));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(keySpec);
            return key;
        } catch (Exception e) {
            throw new Exception("读取公钥失败" + e.getMessage());
        }
    }

    //发送Post请求
    public static String doPostForm(String httpUrl, Map param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            java.net.URL url = new URL(httpUrl);
            // trustAllHttpsCertificates();
            SSLContext sslcontext;
            sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
            sslcontext.init(null, new TrustManager[] { new MyX509TrustManager() }, new java.security.SecureRandom());
            // URL url = new URL("https://xxxx");
            HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
                public boolean verify(String s, SSLSession sslsession) {
                    System.out.println("WARNING: Hostname is not matched for cert.");
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());

            // 新建连接
            connection = (HttpURLConnection) url.openConnection();
            //设置为POST请求
            connection.setRequestMethod("POST");
            // 设置连接超时时长
            connection.setConnectTimeout(15000);
            // 设置读取超时
            connection.setReadTimeout(60000);
            connection.setInstanceFollowRedirects(true);

            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            os = connection.getOutputStream();
            os.write(createLinkString(param).getBytes());
            if (connection.getResponseCode() != 200) {
                is = connection.getErrorStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 获取错误返回
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            } else {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 获取返回
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接
            connection.disconnect();
        }
        return result;
    }

    public static String createLinkString(Map<String, String> params) throws UnsupportedEncodingException {

        ArrayList<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        StringBuilder prestr = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }

        return prestr.toString();
    }

    public static String serialJsonOrdered(JSONObject json) {
        StringBuilder appender = new StringBuilder();
        appender.append("{");
        Iterator<String> keys = new TreeSet<>(json.keySet()).iterator();
        boolean isFirstEle = true;
        while (keys.hasNext()) {
            if (!isFirstEle) {
                appender.append(",");
            }
            String key = keys.next();
            Object val = json.get(key);
            if (val instanceof JSONObject) {
                appender.append("\"").append(key).append("\":");
                appender.append(serialJsonOrdered((JSONObject) val));
            } else if (val instanceof JSONArray) {
                JSONArray jarray = (JSONArray) val;
                appender.append("\"").append(key).append("\":[");
                boolean isFirstArrEle = true;
                for (int i = 0; i < jarray.length(); i++) {
                    if (!isFirstArrEle) {
                        appender.append(",");
                    }
                    Object obj = jarray.get(i);
                    if (obj instanceof JSONObject) {
                        appender.append(serialJsonOrdered((JSONObject) obj));
                    } else {
                        appender.append("\"" + replaceSlash(obj.toString()) + "\"");
                    }
                    isFirstArrEle = false;
                }
                appender.append("]");
            } else {
                String value = "";
                if (val instanceof String) {
                    value = "\"" + replaceSlash(val.toString()) + "\"";
                } else {
                    value = replaceSlash(val.toString());
                }
                appender.append("\"").append(key).append("\":").append(value);
            }
            isFirstEle = false;
        }
        appender.append("}");
        return appender.toString();
    }

    private static String replaceSlash(String val1) {

        StringBuilder buffer = new StringBuilder();
        char[] arr = val1.toCharArray();
        for (char c : arr) {
            if (c == '\\') {
                buffer.append(c).append(c);
            } else if (c == '\"') {
                buffer.append('\\').append(c);
            } else if (c == '\r') {
                buffer.append("\\r");
            } else if (c == '\n') {
                buffer.append("\\n");
            } else if (c == '\b') {
                buffer.append("\\b");
            } else if (c == '\t') {
                buffer.append("\\t");
            } else if (c == '\f') {
                buffer.append("\\f");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}

class MyX509TrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        // TODO Auto-generated method stub

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        // TODO Auto-generated method stub
        return null;
    }
}

class Base64 {
    private Base64() {
    }

    public static String encode(byte data[]) {
        StringBuilder sb = new StringBuilder();
        int len = data.length;
        for (int i = 0; i < len;) {
            int b1 = data[i++] & 255;
            if (i == len) {
                sb.append(ENCODE_CHARS[b1 >>> 2]);
                sb.append(ENCODE_CHARS[(b1 & 3) << 4]);
                sb.append("==");
                break;
            }
            int b2 = data[i++] & 255;
            if (i == len) {
                sb.append(ENCODE_CHARS[b1 >>> 2]);
                sb.append(ENCODE_CHARS[(b1 & 3) << 4 | (b2 & 240) >>> 4]);
                sb.append(ENCODE_CHARS[(b2 & 15) << 2]);
                sb.append("=");
                break;
            }
            int b3 = data[i++] & 255;
            sb.append(ENCODE_CHARS[b1 >>> 2]);
            sb.append(ENCODE_CHARS[(b1 & 3) << 4 | (b2 & 240) >>> 4]);
            sb.append(ENCODE_CHARS[(b2 & 15) << 2 | (b3 & 192) >>> 6]);
            sb.append(ENCODE_CHARS[b3 & 63]);
        }

        return sb.toString();
    }

    public static byte[] decode(String str) {
        byte data[] = str.getBytes();
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        for (int i = 0; i < len;) {
            int b1;
            do
                b1 = DECODE_CHARS[data[i++]];
            while (i < len && b1 == -1);
            if (b1 == -1)
                break;
            int b2;
            do
                b2 = DECODE_CHARS[data[i++]];
            while (i < len && b2 == -1);
            if (b2 == -1)
                break;
            buf.write(b1 << 2 | (b2 & 48) >>> 4);
            int b3;
            do {
                b3 = data[i++];
                if (b3 == 61)
                    return buf.toByteArray();
                b3 = DECODE_CHARS[b3];
            } while (i < len && b3 == -1);
            if (b3 == -1)
                break;
            buf.write((b2 & 15) << 4 | (b3 & 60) >>> 2);
            int b4;
            do {
                b4 = data[i++];
                if (b4 == 61)
                    return buf.toByteArray();
                b4 = DECODE_CHARS[b4];
            } while (i < len && b4 == -1);
            if (b4 == -1)
                break;
            buf.write((b3 & 3) << 6 | b4);
        }

        return buf.toByteArray();
    }

    private static final int INT2 = 2;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final int INT61 = 61;
    private static final char ENCODE_CHARS[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
    private static final byte DECODE_CHARS[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };

}
