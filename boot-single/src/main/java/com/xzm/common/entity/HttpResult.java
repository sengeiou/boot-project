package com.xzm.common.entity;

import lombok.Data;

/**
 * Created by Administrator on 2016/8/29.
 */
@Data
public class HttpResult<T> {

    /**
     * result 用来模仿Date层数据结构
     */

//    "resultcode": "101",
    private  int    resultcode;
    private String reason;
    private int error_code;

    private T result;


    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    /**
     * reason : 请求成功
     * result : {"list":[{"id":"wechat_20170216032032","title":"xx","source":"xx",
     * "firstImg":"xx","mark":"","url":"xx"},{"id":"wechat_20170216032143","title":"xxx",
     * "source":"xx","firstImg":"xx","mark":"","url":"xxx"}],"totalPage":4013,"ps":2,"pno":1}
     * error_code : 0
     */



    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "resultcode=" + resultcode +
                ", reason='" + reason + '\'' +
                ", error_code=" + error_code +
                ", result=" + result +
                '}';
    }
}
