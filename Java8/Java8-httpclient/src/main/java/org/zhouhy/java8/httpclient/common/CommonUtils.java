package org.zhouhy.java8.httpclient.common;




import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.zhouhy.java8.httpclient.domain.HttpClientResult;



public class CommonUtils {
	
	private static final String ENCODING = "UTF-8";
    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 6000;
    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 6000;
    
    private  static RequestConfig requestConfig = null;
 
    static{
        RequestConfig.Builder builder = RequestConfig.custom();
        builder.setConnectTimeout(CONNECT_TIMEOUT); //设置连接超时时间，单位毫秒
        builder.setSocketTimeout(SOCKET_TIMEOUT); //请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
        requestConfig = builder.build();
    }


	
	public static HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException{
		
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		
		SSLConnectionSocketFactory sslConnectionSocketFactory 
					= new SSLConnectionSocketFactory(builder.build(),NoopHostnameVerifier.INSTANCE);
		
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http",new PlainConnectionSocketFactory())
				.register("https",sslConnectionSocketFactory)
				.build();
		
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		
		cm.setMaxTotal(200);
		
		CloseableHttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(sslConnectionSocketFactory)
				.setConnectionManager(cm)
				.build();		
		
		return httpClient;		
	}
	
	public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = doGetHandle(url, headers, params);
        return getHttpClientResult(httpClient,httpGet,null);
    }
	
	public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = doPosthandle(url, headers, params);
        return getHttpClientResult(httpClient,httpPost,null);
    }
	
	public static HttpClientResult doGet(String url) throws Exception {
        return doGet(url, null, null);
    }
 
    /**
     * 发送get请求；带请求参数
     *
     * @param url 请求地址
     * @param params 请求参数集合
     * @throws Exception
     */
    public static HttpClientResult doGet(String url, Map<String, String> params) throws Exception {
        return doGet(url, null, params);
    }
 
 
    /**
     * 发送post请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String url) throws Exception {
        return doPost(url, null, null);
    }
 
    /**
     * 发送post请求；带请求参数
     *
     * @param url 请求地址
     * @param params 参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String url, Map<String, String> params) throws Exception {
        return doPost(url, null, params);
    }


	public static HttpGet doGetHandle(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建访问的地址
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }
        // 创建http对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setConfig(requestConfig);
        // 设置请求头
        packageHeader(headers, httpGet);
        return httpGet;
    }
	
	public static HttpPost doPosthandle(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        // 创建http对象
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // 设置请求头
        packageHeader(headers, httpPost);
        // 封装请求参数
        packageParam(params, httpPost);
        // 执行请求并获得响应结果
        return httpPost;
    }

	
	public static HttpClientResult getHttpClientResult(CloseableHttpClient httpClient, HttpRequestBase httpMethod, HttpClientContext httpClientContext) {
		 
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpMethod,httpClientContext);
            if(response == null || response.getStatusLine() == null){
                return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            }
            String content = "";
            if (response.getEntity() != null) {
                content = EntityUtils.toString(response.getEntity(), ENCODING);
            }
 
            Header cookie = response.getFirstHeader("Set-Cookie");
            System.out.println( cookie.getName());
            System.out.println( cookie.getValue());
 
            return new HttpClientResult(response.getStatusLine().getStatusCode(), content);
 
        }catch (Exception e){
            e.printStackTrace();
            return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }finally {
            try {
                release(response,httpClient);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // 封装请求参数
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
 
            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

	
	public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }
	
	public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        // 释放资源
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }
	
}
