package com.guaju.a919test.login;

import com.guaju.a919test.base.BaseView;

/**
 * Created by guaju on 2017/9/21.
 */

public interface LoginContract {
       //view接口
    interface  view extends BaseView {
         void  loginSuccess();
         void  loginFaliure();

       }


    interface  presenter{
        void notifyFormat(String phone);
        void login();
    }

}
