package nju.software.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2016/1/3.
 */
public class HttpClientBase {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://software.nju.edu.cn:8080/");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            EntityUtils.consume(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response1.close();
        }

        HttpPost httpPost = new HttpPost("http://software.nju.edu.cn:8000/?q=login.do");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", "***"));
        nvps.add(new BasicNameValuePair("password", "***"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            EntityUtils.consume(entity2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
