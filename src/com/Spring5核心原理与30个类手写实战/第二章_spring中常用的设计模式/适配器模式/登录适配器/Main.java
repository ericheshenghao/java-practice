package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.适配器模式.登录适配器;

import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
        SiginForThirdService siginForThirdService = new SiginForThirdService();
        siginForThirdService.loginForQQ("943452349");
    }
}


class ResultMsg{
    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}


class Member{
    private String username;
    private String password;
    private String mid;
    private String info;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

class SiginService{
    public ResultMsg register(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    public ResultMsg login(String username,String password){
        return null;
    }
}

class SiginForThirdService extends SiginService{
    public ResultMsg loginForQQ(String openID){
        return login(openID,null);
    }

    public ResultMsg loginForWechat(String openID){
        return login(openID,null);
    }

    public ResultMsg loginForToken(String token){
        // 通过token获取信息，再次登录
        return null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){
        // 通过token获取信息，再次登录
        return null;
    }

    public ResultMsg loginForRegister(String username,String password){
        // 通过token获取信息，再次登录
        super.register(username,null);
        return super.login(username,password);
    }

}

//////////////////////////////
