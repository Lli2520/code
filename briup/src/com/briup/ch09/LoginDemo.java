package com.briup.ch09;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/18 下午3:57
 * @Description
 **/

public class LoginDemo {
    public  static String login(String name, String password) throws LoginException {
        if (!"briup".equals(name)){
            throw new LoginException("用户名不存在");
        }else if (!"briup".equals(password)){
            throw new  LoginException("密码错误");
        }else{
            return  "登录成功；欢迎用户 briup";
        }

    }

    public static void main(String[] args) {
        try {
            String s = login("briup", "briup");
            System.out.println(s);
        } catch (LoginException e) {
            System.out.println("登录失败："+e.getMessage());
        }

    }
}
