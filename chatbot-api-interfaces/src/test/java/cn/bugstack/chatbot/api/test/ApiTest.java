package cn.bugstack.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112145142824/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"186c51dd73ac5b-0a4163195aabca8-26031951-2073600-186c51dd73ba04\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YzUxZGQ3M2FjNWItMGE0MTYzMTk1YWFiY2E4LTI2MDMxOTUxLTIwNzM2MDAtMTg2YzUxZGQ3M2JhMDQifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"186c51dd73ac5b-0a4163195aabca8-26031951-2073600-186c51dd73ba04\"}; zsxq_access_token=EA536226-9A47-832F-85E0-96B2AC66097D_D6FB7D3BC54E13B5; abtest_env=product; zsxqsessionid=1caa43c0b3092a5df85543bdaaac268d");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/181444882451212/answer");
        post.addHeader("cookie","_uab_collina=167834431419208641685974; _uab_collina=167834511110586240325988; sensorsdata2015jssdkcross={\"distinct_id\":\"186c51dd73ac5b-0a4163195aabca8-26031951-2073600-186c51dd73ba04\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YzUxZGQ3M2FjNWItMGE0MTYzMTk1YWFiY2E4LTI2MDMxOTUxLTIwNzM2MDAtMTg2YzUxZGQ3M2JhMDQifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"186c51dd73ac5b-0a4163195aabca8-26031951-2073600-186c51dd73ba04\"}; zsxq_access_token=EA536226-9A47-832F-85E0-96B2AC66097D_D6FB7D3BC54E13B5; abtest_env=product");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"吃汉堡！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void test_ChatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","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");

        String paramJson = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"帮我写一个冒泡排序\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
