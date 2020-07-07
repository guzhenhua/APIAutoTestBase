package com.base;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @PACKAGE_NAME: com.base
 * @NAME: TestBase
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 11:17
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 11
 * @MINUTE: 17
 * @PROJECT_NAME: 这个类作为所有接口请求测试的父类，都需要继承这个父类,实现加载读取properties文件
 */


public class TestBase {
    public static final String filepath="E:\\CSDN\\src\\main\\java\\com\\config\\config.properties";
    public Properties prop;

    //写一个构造函数
    public TestBase() {

        try {
            prop = new Properties();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            prop.load(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_ee(){
        TestBase testBase = new TestBase();
        String urlpath=testBase.prop.getProperty("HOST");
        System.out.println(urlpath);
    }
}
