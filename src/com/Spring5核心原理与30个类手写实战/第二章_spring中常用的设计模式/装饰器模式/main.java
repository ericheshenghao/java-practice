package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.装饰器模式;

public class main {
    public static void main(String[] args) {
        SiginForThirdService singinForThirdService = new SiginForThirdService(new ISigninServiceImpl());
        singinForThirdService.loginForQQ("943452349");
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


interface ISigninService {
    ResultMsg register(String username,String password);

    ResultMsg login(String username,String password);

}

 class ISigninServiceImpl implements ISigninService {
     @Override
     public ResultMsg register(String username, String password) {
           return new ResultMsg(200,"注册成功",new Member());
     }

     @Override
     public ResultMsg login(String username, String password) {
         return null;
     }
 }

 interface ISiginForThirdService extends  ISigninService {
     ResultMsg loginForQQ(String id);

     ResultMsg loginForWechat(String id);

     ResultMsg loginForToken(String token);

     ResultMsg loginForTel(String telphone, String code);

     ResultMsg loginForRegister(String username, String password);

 }


 class SiginForThirdService implements ISiginForThirdService{
    private ISigninService signin;

     public SiginForThirdService(ISigninService signin) {
         this.signin = signin;
     }

     @Override
     public ResultMsg register(String username, String password) {
         return signin.register(username, password);
     }

     @Override
     public ResultMsg login(String username, String password) {
         return signin.login(username,password);
     }

     @Override
     public ResultMsg loginForQQ(String id) {
         return null;
     }

     @Override
     public ResultMsg loginForWechat(String id) {
         return null;
     }

     @Override
     public ResultMsg loginForToken(String token) {
         return null;
     }

     @Override
     public ResultMsg loginForTel(String telphone, String code) {
         return null;
     }

     @Override
     public ResultMsg loginForRegister(String username, String password) {
         return null;
     }
 }