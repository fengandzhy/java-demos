import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.zhouhy.java8.httpclient.HttpClientUtils;

public class HttpClientUtilTest {

	
	
	@Test
	public void testSendHttpPost3() {// https://209.160.54.4/suns/XML_Rx.php
		String url = "http://192.168.1.180:4050";
		try {
			String responseContent = HttpClientUtils.postXML(url,
					"<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" + "<Transfer attribute=\"Connect\">\n"
							+ "<ext id=\"20013\"/>\n" + "<outer to=\"15505510628\"/>\n" + "</Transfer>");
			System.out.println(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSendHttpPost2() {
		String url = "http://192.168.1.180:4050";
		try {
			StringEntity entity = new StringEntity(
					"<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" + "<Transfer attribute=\"Connect\">\n"
							+ "<ext id=\"20013\"/>\n" + "<outer to=\"15505510628\"/>\n" + "</Transfer>",
					"UTF-8"); // <span style="color:rgb(85,85,85);font-family:'宋体', 'Arial Narrow', arial,
								// serif;font-size:14px;">不指定参数名的方式来POST数据</span>
			String responseContent = HttpClientUtils.post(url, null, null, entity);
			System.out.println(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
