package com.dkm.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //返回状态码
    private String code;
    //返回信息
    private String msg;
    //返回这些信息放在一个map中
    private Map<String,Object> extend = new HashMap<String,Object>();

    //处理信息成功方法
    public static Msg success(){
        Msg result = new Msg();
        result.setCode("200");
        result.setMsg("处理信息成功");
        return result;
    }
//处理信息失败方法
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode("400");
        result.setMsg("处理信息失败");
        return result;
    }
//添加一个快速返回信息的方法
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
