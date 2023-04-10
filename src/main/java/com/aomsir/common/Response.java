package com.aomsir.common;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
public class Response<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    /**
     * 返回实体数据，需要泛型
     * @param object
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T object) {
        Response<T> r = new Response<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    /**
     * 返回错误信息，所以不需要泛型
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Response<T> error(String msg) {
        Response<T> r = new Response<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public Response<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }


    public Response() {
    }

    public Response(Integer code, String msg, T data, Map map) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.map = map;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", map=" + map +
                '}';
    }
}
