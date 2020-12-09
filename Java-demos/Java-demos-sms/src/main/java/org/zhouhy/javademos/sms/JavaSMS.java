package org.zhouhy.javademos.sms;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class JavaSMS {

    private static String Url = "http://gbk.sms.webchinese.cn";
    
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");// 在头文件中设置转码 
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int mobile_code = (int)((Math.random()*9+1)*100000);

        String content = new String("周洪元祝您生日快乐，您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
//                new NameValuePair("account", "xxxxxx"),// 注册的用户名  
//                new NameValuePair("password", "xxxxxxx"), //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
//                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
//                new NameValuePair("mobile", "xxxxx"),//要发的手机
//                new NameValuePair("content", content),//要发的内容
                new NameValuePair("Uid", "appartment"),//用户名
                new NameValuePair("Key", "d41d8cd98f00b204e980"),//密码
                new NameValuePair("smsMob","18930319510"),//电话号码
                new NameValuePair("smsText",content)
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);//发送短信

            Header[] headers = method.getResponseHeaders();//短信返回信息
            int statusCode = method.getStatusCode();//状态码
            System.out.println("statusCode:" + statusCode);
            for (Header h : headers) {//响应头的打印
                System.out.println(h.toString());
            }
            String result = null;

            result = new String(method.getResponseBodyAsString().getBytes(
                    "gbk"));//打印响应体

            System.out.println(result);
            method.releaseConnection();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
