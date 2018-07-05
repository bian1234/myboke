package com.byk.myboke.commen.util;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:49
 * @Todo:  数据响应工具类
 */

public class RestUtil {

    private int status;

    private  String msg;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestUtil{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
