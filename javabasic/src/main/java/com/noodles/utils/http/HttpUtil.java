package com.noodles.utils.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HttpUtil {

	private static String charset1 = "utf-8";

	/**
	 * 
	 * @param url 访问路径
	 * @param map 传递的参数
	 * @param charset  字符集 默认utf-8
	 * @return
	 * 作者：brian.li
	 * 日期：2016年5月5日上午11:17:37
	 */
	public static String doPost(String url, Map<String, Object> map, String charset) {
		if (charset == null || charset.equals("")) {
			charset = charset1;
		}
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("网络请求异常");
		}
		return result;
	}

	public static String httpGet(String url, Map<String, Object> map, String charset, Map<String, Object> headmap) {
		if (charset == null || charset.equals("")) {
			charset = charset1;
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		HttpClient hc = new DefaultHttpClient();
		for (String key : map.keySet()) {
			params.add(new BasicNameValuePair(key, map.get(key) + ""));
		}
		String body = null;
		// 设置参数
		HttpGet httpget = new HttpGet(url);
		if (headmap != null) {
			for (String key : headmap.keySet()) {
				httpget.addHeader(key, headmap.get(key) + "");
			}
		}
		String str;
		try {
			str = EntityUtils.toString(new UrlEncodedFormEntity(params, charset));
			httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
			// 发送请求
			HttpResponse httpresponse = hc.execute(httpget);
			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity);
			if (entity != null) {
				entity.consumeContent();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return body;
	}

	/**
	 * 
	 * 创建时间：2015年8月21日 下午2:22:43
	 * 创建人： Brian	
	 * 方法描述：http请求post方法  
	 * @param apiUrl  请求地址
	 * @param params  请求参数
	 * @return 
	 */
	public static String post(String apiUrl, Map<String, Object> params) throws Exception {
		return filepost(apiUrl, params, null);
	}

	/**
	 * 
	 * 创建时间：2015年9月6日 上午11:16:09
	 * 创建人： Brian	
	 * 方法描述：post请求  传入参数为此规则A=123&B=456 
	 * @param apiUrl   请求地址
	 * @param text     需要传的参数
	 * @return
	 * @throws Exception 
	 */
	public static String StringParampost(String apiUrl, String text) throws Exception {
		URL url = new URL(apiUrl);
		// 组织请求参数
		StringBuilder postBody = new StringBuilder();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置连接超时
		// conn.setConnectTimeout(1000);
		// 设置读取超时
		// conn.setReadTimeout(500);
		conn.setRequestProperty("Charset", "utf-8");
		// 提交参数
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.getOutputStream().write(text.getBytes());
		conn.getOutputStream().flush();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuffer result = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

	public static String filepost(String postUrl, Map<String, Object> params, Map<String, byte[]> files)
			throws ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		InputStream is = null;
		String results = null;
		CloseableHttpClient httpclient = createClientDefault(postUrl);
		try {
			HttpPost httppost = new HttpPost(postUrl.trim());

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();

			if (params != null) {
				for (String key : params.keySet()) {
					String str = null;
					if (params.get(key) != null && !params.get(key).equals("")) {
						str = String.valueOf(params.get(key));
						StringBody value = new StringBody(str, ContentType.create("text/plain",
								Charset.forName("UTF-8")));
						builder.addPart(key, value);
					}
				}
			}
			if (files != null && files.size() > 0) {
				for (String key : files.keySet()) {
					byte[] value = files.get(key);
					// FileBody body = new FileBody(new File(value));
					ByteArrayBody body = new ByteArrayBody(value, ContentType.DEFAULT_BINARY, key);
					builder.addPart(key, body);
				}
			}
			HttpEntity reqEntity = builder.build();
			httppost.setEntity(reqEntity);

			response = httpclient.execute(httppost);
			// assertEquals(200, response.getStatusLine().getStatusCode());
			// Validate.isTrue(response.getStatusLine().getStatusCode() == 200);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				is = entity.getContent();
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer, "UTF-8");
				results = writer.toString();
			}

		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Throwable t) {
				// No-op
			}
			try {
				if (response != null) {
					response.close();
				}
			} catch (Throwable t) {
				// No-op
			}

			httpclient.close();
		}
		return results;
	}

	public static CloseableHttpClient createClientDefault(String url) {
		if (url.startsWith("https")) {
			try {
				SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
					public boolean isTrusted(X509Certificate[] chain, String authType)
							throws java.security.cert.CertificateException {
						return true;
					}
				}).build();
				// SSLConnectionSocketFactory sslsf = new
				// SSLConnectionSocketFactory(sslContext,new
				// NoopHostnameVerifier());
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
						new X509HostnameVerifier() {
							public boolean verify(String arg0, SSLSession arg1) {
								return true;
							}

							public void verify(String host, SSLSocket ssl) throws IOException {
							}

							public void verify(String host, X509Certificate cert) throws SSLException {
							}

							public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
							}

						});
				return HttpClients.custom().setSSLSocketFactory(sslsf).build();
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			}
			return HttpClients.createDefault();
		} else {
			return HttpClients.createDefault();
		}
	}
}