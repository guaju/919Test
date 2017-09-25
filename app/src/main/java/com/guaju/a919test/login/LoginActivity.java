package com.guaju.a919test.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.guaju.a919test.R;
import com.guaju.a919test.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guaju on 2017/9/21.
 */

public class LoginActivity extends BaseActivity implements LoginContract.view {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.notify)
    Button notify;
    LoginContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter=new LoginPresenterImpl(this);
        ButterKnife.bind(this);
    }

    @Override
    public void loginSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void loginFaliure() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "账号或密码错误，请重新填写", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @OnClick(R.id.notify)
    public void onViewClicked() {
        //校验
        String phone = username.getText().toString().trim();
        presenter.notifyFormat(phone);

    }
}
