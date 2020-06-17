package org.zhouhy.java8.httpclient.demos;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimpleTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("http://www.datalearner.com/blog");
		
		CloseableHttpResponse response = null;
		
		response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		
		
		
	}

}
