package com.guaju.a919test.list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.guaju.a919test.R;
import com.guaju.a919test.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ListContract.View {
    ListContract.presenter presenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new ListPresenterImpl(this);
        presenter.initData(recyclerview);
    }


    @Override
    public void showList() {

    }

    @Override
    public void showEmpty() {

    }
}
