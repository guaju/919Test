package com.guaju.a919test.base;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by guaju on 2017/9/21.
 */

public class BaseActivity extends Activity implements BaseView {
    @Override
    public void networkError() {
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  Toast.makeText(BaseActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
              }
          });
    }

    @Override
    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, "加载中", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, "加载完成，正在隐藏", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
