package com.data;

/**
 * @PACKAGE_NAME: com.data
 * @NAME: Users
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 16:26
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 16
 * @MINUTE: 26
 * @PROJECT_NAME: CSDN
 */
public class Users {
        String data;
        String msg;
        int ret;

    public String getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getRet() {
        return ret;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Users(String data, String msg, int ret) {
        this.data = data;
        this.msg = msg;
        this.ret = ret;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "data='" + data + '\'' +
                ", msg='" + msg + '\'' +
                ", ret=" + ret +
                '}';
    }
}
