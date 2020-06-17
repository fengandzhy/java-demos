package org.zhouhy.java8.httpclient.demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class SecondTest {

	public static void main(String[] args) throws URISyntaxException, ParseException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		InputStream is = null;
		String url="https://qasupporthub.security.gallagher.com/@api/deki/users/authenticate";
		
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("Username", "Frank.Zhou"));
		params.add(new BasicNameValuePair("Password", "rKlMvNjU"));
		String str = "";
		str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		
				
		HttpGet httpGet = new HttpGet(url+"?"+str);		
		response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		InputStream in = entity.getContent();
		StringBuilder builder=new StringBuilder();
		BufferedReader bufreader =new BufferedReader(new InputStreamReader(in));
		for (String temp=bufreader.readLine();temp!=null;temp= bufreader.readLine()) {
			builder.append(temp);
		}
		System.out.println(builder.toString());
	}

}
