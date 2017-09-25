package com.guaju.a919test.login;

import android.widget.Toast;

import com.guaju.a919test.model.LoginModel;

/**
 * Created by guaju on 2017/9/21.
 */

public class LoginPresenterImpl implements LoginContract.presenter {

    private final LoginActivity loginActivity;

    public LoginPresenterImpl(LoginContract.view view) {
        this.view = view;
        loginActivity = (LoginActivity) view;
    }

    LoginContract.view view;
    @Override
    public void notifyFormat(String phonenum) {

       //手机号校验
        LoginModel loginModel = new LoginModel();
        boolean format = loginModel.format(phonenum);
        if (phonenum.equals("")){
            Toast.makeText(loginActivity, "请输入手机号", Toast.LENGTH_SHORT).show();
        }else if (phonenum.length()<11){
            Toast.makeText(loginActivity, "未满11位，请检查手机号", Toast.LENGTH_SHORT).show();
        }else if (format){
            Toast.makeText(loginActivity, "校验成功", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(loginActivity, "校验失败", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void login() {

    }
}
