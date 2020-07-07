package com.tests;

import com.alibaba.fastjson.JSONObject;
import com.base.TestBase;
import com.restclient.RestClient;
import com.util.TestUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @PACKAGE_NAME: com.tests
 * @NAME: GetApiTest
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 11:39
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 11
 * @MINUTE: 39
 * @PROJECT_NAME: 写一个TestNG的测试用例来测试下我们上面写的Get请求方法
 */
public class GetApiTest extends TestBase {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/test/login?userId=17962";

    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        CloseableHttpResponse httpResponse = restClient.get(url);
        //断言状态码是不是200
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200, "response status code is not 200");
    }

    @Test
    public void getAPITest1() throws ClientProtocolException, IOException {
        CloseableHttpResponse httpResponse = restClient.get(url);
        //断言状态码是不是200
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String Response = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(Response);
        String data = TestUtil.getValueByJPath(jsonObject, "data");
        Assert.assertEquals(data,"02b277a658184ad1a2a5833c94f85902","response data  is not right");
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200, "response status code is not 200");
    }
}

