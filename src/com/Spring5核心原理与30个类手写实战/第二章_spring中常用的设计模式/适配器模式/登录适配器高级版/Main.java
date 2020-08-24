package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.适配器模式.登录适配器高级版;


import java.text.SimpleDateFormat;

public class Main {
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

class SiginService{
    public ResultMsg register(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    // 登录逻辑
    public ResultMsg login(String username,String password){
        return null;
    }
}


interface LoginAdapter{
    boolean support(Object adapter);
    ResultMsg login(String id, Object adpater);
}

class LoginForQQAdapter extends SiginService implements LoginAdapter{

    @Override
    public boolean support(Object adapter) {
        return  adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adpater) {
        return login(id,null);
   }
}

interface IPassportForThird{
    ResultMsg loginForQQ(String id);
    ResultMsg loginForWechat(String id);
}



class PassportForThirdAdapter extends SiginService implements IPassportForThird{

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }



    private ResultMsg processLogin(String key,Class<? extends LoginAdapter> clazz){
        try {
            LoginAdapter loginAdapter = clazz.newInstance();
            if(loginAdapter.support(loginAdapter)){
                return loginAdapter.login(key,loginAdapter);
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}




class main{
    public static void main(String[] args) {
        PassportForThirdAdapter passportForThirdAdapter = new PassportForThirdAdapter();
        passportForThirdAdapter.loginForQQ("");
    }
}
