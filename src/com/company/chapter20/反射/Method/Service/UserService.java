package com.company.chapter20.反射.Method.Service;

public class UserService {
    /**
     * 登录方法
     *
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name, String password) {
        if ("admin".equals(name) && "123".equals(password)) {
            return true;
        }
        return false;
    }

    public void logout() {
        System.out.println("退出成功");
    }

}
