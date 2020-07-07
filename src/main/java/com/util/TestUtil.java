package com.util;

/**
 * @PACKAGE_NAME: com.util
 * @NAME: TestUtil
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 15:43
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 15
 * @MINUTE: 43
 * @PROJECT_NAME: 一个JSON解析的工具类
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * responseJson ,这个变量是拿到响应字符串通过json转换成json对象
 * jpath,这个jpath指的是用户想要查询json对象的值的路径写法
 * jpath写法举例：1) per_page  2)data[1]/first_name ，data是一个json数组，[1]表示索引
 * /first_name 表示data数组下某一个元素下的json对象的名称为first_name
 * jpath的写法就是data[0]/first_name
 *
 * @return，返回first_name这个json对象名称对应的值
 */

public class TestUtil {
    //1 json解析方法

    public static String getValueByJPath(JSONObject responseJson, String jpath) {
        Object obj = responseJson;
        for (String s : jpath.split("/")) {
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = ((JSONObject) obj).get(s);
                } else if (s.contains("[") || s.contains("]")) {
                    try {
                        obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                    } catch (Exception e) {
                        System.out.println("路径可能有问题");
                    }

                }
            }
        }
        return obj.toString();
    }

//    public static void main(String[] args) {
//        String responseString = "{\"data\":{\"limit\":10,\"page\":1,\"rows\":[{\"clubId\":1153,\"clubName\":\"顾_电竞社\",\"college\":\"哈否大学\",\"createTime\":\"2020-07-07 15:11\",\"logoUrl\":\"https://djs-oss.fejj.com/club/a3922a100c0247398046b8c400e45d7c.png\",\"proprieterName\":\"仙道\",\"proprieterTel\":\"13028866960\",\"status\":1,\"teamCount\":3,\"tel\":\"\",\"userCount\":2},{\"clubId\":1152,\"clubName\":\"没有电竞\",\"college\":\"德福喜大学\",\"createTime\":\"2020-07-07 13:55\",\"logoUrl\":\"https://djs-oss.fejj.com/club/a3922a100c0247398046b8c400e45d7c.png\",\"proprieterName\":\"时间老人\",\"proprieterTel\":\"13725548926\",\"status\":1,\"teamCount\":-2,\"tel\":\"\",\"userCount\":2}],\"total\":2},\"msg\":\"操作成功！\",\"ret\":0}";
//        JSONObject object = JSON.parseObject(responseString);
//        String data = TestUtil.getValueByJPath(object, "data/rows[1]/clubName");
//        System.out.println(data);
//    }

}
