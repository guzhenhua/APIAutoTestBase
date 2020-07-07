package com.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.base.TestBase;
import com.data.Users;
import com.restclient.RestClient;
import com.util.TestUtil;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * @PACKAGE_NAME: com.tests
 * @NAME: PostApiTest
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 16:28
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 16
 * @MINUTE: 28
 * @PROJECT_NAME: CSDN
 */
public class PostApiTest extends TestBase {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("POST_HOST");
        url = host + "/api/admin/team/school/create";
    }

    @Test
    public void postAPITest() throws ClientProtocolException, IOException {
        //1.准备请求头
        HashMap<String,String> headermap = new HashMap<String,String>();
        headermap.put("Content-Type", "application/json");
        headermap.put("X-Token", "7cc9c7fdc773411294ef7be1049efa35");

//        2.对象转换成Json字符串
        Users users = new Users("998",2,"https://test-djs-oss.jdian88.com/club/f3316601cebc46c79f1ae86ff8c0cca7.jpg");
        String toJSONString = JSON.toJSONString(users);
        System.out.println(toJSONString);

        closeableHttpResponse = restClient.post(url,toJSONString,headermap);
        System.out.println(closeableHttpResponse.toString());
        //断言状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200, "response status code is not 200");

        //断言响应json内容中是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseString);
//        String data = TestUtil.getValueByJPath(responseJson, "data");
//        Assert.assertEquals(data,"901","response data code is not 901");
    }

}
