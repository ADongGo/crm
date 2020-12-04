package cn.offcn.utils;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Crm自定义响应结构
 */
public class OAResult implements Serializable{

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public static OAResult build(Integer status, String message, Object data) {
        return new OAResult(status, message, data);
    }

    public static OAResult ok(Object data) {
        return new OAResult(data);
    }

    public static OAResult ok(Integer status,String message) {
        return new OAResult(status,message);
    }

    public static OAResult ok(Integer status,String message,Object data) {
        return new OAResult(status,message,data);
    }

    public static OAResult ok() {
        return new OAResult(null);
    }

    public OAResult() {

    }

    public static OAResult build(Integer status, String message) {
        return new OAResult(status, message, null);
    }

    public OAResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public OAResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public OAResult(Object data) {
        this.status = 200;
        this.message = "OK";
        this.data = data;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
