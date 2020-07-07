package com.tests;

import com.base.TestBase;
import com.restclient.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
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
        url = host + "/test/login?userId=17947";

    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        CloseableHttpResponse httpResponse = restClient.get(url);
        //断言状态码是不是200
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200, "response status code is not 200");
    }

}
