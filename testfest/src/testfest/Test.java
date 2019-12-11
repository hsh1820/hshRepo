package testfest;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;



public class Test {
	
	URL url = null;
	URLConnection connection = null;
	StringBuilder responseBody = new StringBuilder();
try {
	url = new URL("https://pay.toss.im/api/v1/payments");
	connection = url.openConnection();
	connection.addRequestProperty("Content-Type", "application/json");
	connection.setDoOutput(true);
	connection.setDoInput(true);

	org.json.simple.JSONObject jsonBody = new JSONObject();
	jsonBody.put("orderNo", "1");
	jsonBody.put("amount", 10000);
	jsonBody.put("amountTaxFree", 0);
	jsonBody.put("productDesc", "테스트 결제");
	jsonBody.put("apiKey", "sk_test_w5lNQylNqa5lNQe013Nq");
    jsonBody.put("autoExecute", true);
    jsonBody.put("resultCallback", "http://"http://YOUR-SITE.COM/callback");
    jsonBody.put("retUrl", "http://YOUR-SITE.COM/ORDER-CHECK?orderno=1");
    jsonBody.put("retCancelUrl", "http://YOUR-SITE.COM/close");

	BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
	
    bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
	bos.flush();
	bos.close();

	
    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
	String line = null;
	while ((line = br.readLine()) != null) {
		responseBody.append(line);
	}
	br.close();
} catch (Exception e) {
	responseBody.append(e);
}
System.out.println(responseBody.toString());
}