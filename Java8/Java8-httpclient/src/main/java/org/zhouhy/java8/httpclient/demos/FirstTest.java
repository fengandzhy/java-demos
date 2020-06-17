package org.zhouhy.java8.httpclient.demos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.zhouhy.java8.httpclient.common.CommonUtils;

public class FirstTest {
	
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = CommonUtils.getHttpClient();
		String url="https://qasupporthub.security.gallagher.com/@api/deki/users/authenticate";
		HttpGet get=new HttpGet(url);
		
		HttpClientContext context=new HttpClientContext();
		CredentialsProvider credentialsProvider=new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("Frank.Zhou", "rKlMvNjU"));
		context.setCredentialsProvider(credentialsProvider);
		CloseableHttpResponse execute = (CloseableHttpResponse) httpClient.execute(get, context);
		
		HttpEntity entity = execute.getEntity();
		InputStream in = entity.getContent();
		StringBuilder builder=new StringBuilder();
		BufferedReader bufreader =new BufferedReader(new InputStreamReader(in));
		for (String temp=bufreader.readLine();temp!=null;temp= bufreader.readLine()) {
			builder.append(temp);
		}
		System.out.println(builder.toString());
	}
}
