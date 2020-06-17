package org.zhouhy.java8.httpclient.domain;

public class HttpClientResult {
	
	private Integer code;
    private String content;
 
 
    public Integer getCode() {
        return code;
    }
 
    public void setCode(Integer code) {
        this.code = code;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    public HttpClientResult(Integer code, String content) {
        this.code = code;
        this.content = content;
    }
 
    public HttpClientResult(Integer code) {
        this.code = code;
    }
 
    @Override
    public String toString() {
        return "HttpClientResult{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }

}
