package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.Constant;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * Http客户端
 *
 * @author loujinhe
 * @date 2015年9月29日 上午9:27:08
 * @version 1.0
 * @Copyright Copyright (c) 2015 www.gpyh.com All Rights Reserved.
 */
@Slf4j
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/** 远程接口返回码 */
	private static final String RET_CODE = "retCode";

	/** 远程接口返回信息 */
	private static final String RET_MSG = "retMsg";

	private static PoolingHttpClientConnectionManager connManager = null;

	private static CloseableHttpClient httpclient = null;

	/** HTTP保留时间 */
	private final static int MAX_HTTP_KEEP_ALIVE = 30 * 1000;

	/** 最大连接数 */
	private final static int MAX_TOTAL_CONNECTIONS = 800;

	/** 每个路由最大连接数 */
	private final static int MAX_ROUTE_CONNECTIONS = 400;

	/** 获取连接超时时间 */
	private static final int CONNECT_TIMEOUT = 5000;

	/** 连接处理超时时间 */
	private static final int SOCKET_TIMEOUT = 20000;

	static {
		HttpRequestRetryHandler myRetryHandler = customRetryHandler();
		ConnectionKeepAliveStrategy customKeepAliveHander = customKeepAliveHander();
		connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		connManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
		HttpHost localhost = new HttpHost("locahost", 80);
		connManager.setMaxPerRoute(new HttpRoute(localhost), 50);
		httpclient = HttpClients.custom().setConnectionManager(connManager).setKeepAliveStrategy(customKeepAliveHander)
				.setRetryHandler(myRetryHandler).build();
	}

	/**
	 *
	 * http get utf8 请求
	 *
	 * @param url
	 * @return
	 */
	public static String httpGetUtf8(String url) {
		return httpGet(url, null, Constant.CHARSET_UTF8);
	}

	/**
	 *
	 * http get utf8 请求
	 *
	 * @param url
	 * @param params
	 *            转换为?key1=value1&key2=value2
	 * @return
	 */
	public static String httpGetUtf8(String url, Map<String, String> params) {
		return httpGet(url, params, Constant.CHARSET_UTF8);
	}

	/**
	 *
	 * http get 请求
	 *
	 * @param url
	 * @param charset
	 * @return
	 */
	public static String httpGet(String url, String charset) {
		return httpGet(url, null, charset);
	}

	/**
	 *
	 * http get 请求
	 *
	 * @param url
	 * @param params
	 *            转换为?key1=value1&key2=value2
	 * @return
	 */
	public static String httpGet(String url, Map<String, String> params, String charset) {
		CloseableHttpResponse response = null;
		if (params != null) {
			url = url + "?" + createLinkString(params);
		}
		logger.info("get请求地址: {}", url);
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT).build();
		httpGet.setConfig(requestConfig);

		String responseData = null;
		try {
			httpGet = new HttpGet(url);
			response = httpclient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				logger.error("{} 接口调用失败：{}", url, response.getStatusLine());
				Map<String, Object> map = Maps.newHashMap();
				map.put(RET_CODE, 0);
				map.put(RET_MSG, "接口调用失败：" + response.getStatusLine());
				return JSON.toJSONString(map);
			}
			HttpEntity entity = response.getEntity();
			responseData = EntityUtils.toString(entity, charset);
			logger.info("{} 请求响应：{}", url, responseData);
			EntityUtils.consume(entity);
		} catch (Exception e) {
			logger.error("接口地址连接错误或远程服务未打开", e);
			Map<String, Object> map = Maps.newHashMap();
			map.put(RET_CODE, 0);
			map.put(RET_MSG, "接口地址连接错误或远程服务未打开");
			responseData = JSON.toJSONString(map);
		} finally {
			httpGet.releaseConnection();
			HttpClientUtils.closeQuietly(response);
		}
		return responseData;
	}

	/**
	 *
	 * http post 请求
	 *
	 * @param url
	 * @param params
	 *
	 * @return
	 */
	public static String httpPost(String url, String params, String mimeType, String charset) {
		String responseData = null;
		CloseableHttpResponse response = null;
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT).build();
		httpPost.setConfig(requestConfig);
		StringEntity reqEntity = new StringEntity(params, ContentType.create(mimeType, charset));
		httpPost.setEntity(reqEntity);
		try {
			logger.info("post地址：{}, 参数：{}", url, params);
			response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				logger.error("{} 接口调用失败：{}", url, response.getStatusLine());
			}
			HttpEntity entity = response.getEntity();
			responseData = EntityUtils.toString(entity, charset);
			logger.info("post地址：{}, 参数：{}, 响应：{}", url, params, responseData);
			EntityUtils.consume(entity);
		} catch (Exception e) {
			logger.error("接口地址连接错误或远程服务未打开", e);
			Map<String, Object> map = Maps.newHashMap();
			map.put(RET_CODE, 0);
			map.put(RET_MSG, "接口地址连接错误或远程服务未打开");
			responseData = JSON.toJSONString(map);
		} finally {
			httpPost.releaseConnection();
			HttpClientUtils.closeQuietly(response);
		}
		return responseData;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 *
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		StringBuffer prestr = new StringBuffer();

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
//				prestr = prestr + key + "=" + value;
				prestr.append(key+"="+value);
			} else {
				//prestr = prestr + key + "=" + value + "&";
				prestr.append(key + "=" + value + "&");
			}
		}
		return prestr.toString();
	}

	/**
	 * 是否重试
	 *
	 * @return false，不重试
	 */
	private static HttpRequestRetryHandler customRetryHandler() {
		HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				return false;
			}

		};
		return myRetryHandler;
	}

	/**
	 * 设置HTTP连接保留时间
	 *
	 * @return 保留策略
	 */
	private static ConnectionKeepAliveStrategy customKeepAliveHander() {
		ConnectionKeepAliveStrategy myKeepAliveHander = new ConnectionKeepAliveStrategy() {

			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return MAX_HTTP_KEEP_ALIVE;
			}

		};
		return myKeepAliveHander;
	}

	public static CloseableHttpResponse simpleHttpPost(HttpPost httpPost) throws ClientProtocolException, IOException {
		return httpclient.execute(httpPost);
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url   发送请求的URL 例如：http://localhost:8080/demo/login
	 * @param param 请求参数 例：{ "userName":"admin", "password":"123456" }
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, Map<String, Object> param) {
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			URL realUrl = createURL(url, param);
			log.info(realUrl.toString());
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 发送POST请求必须设置
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			// 设置通用的请求属性
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.connect();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	private static URL createURL(String url, Map<String, Object> param) throws MalformedURLException {
		if (param == null || param.size() == 0) {
			return new URL(url);
		}
		StringBuilder sb = new StringBuilder(url);
		sb.append("?");
		for (String key : param.keySet()) {
			sb.append(key);
			sb.append("=");
			sb.append(encode(String.valueOf(param.get(key))));
			sb.append("&");
		}
		return new URL(sb.substring(0, sb.length() - 1));
	}

	private static String encode(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
