package com.guaju.a919test.list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.guaju.a919test.R;
import com.guaju.a919test.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ListContract.View {
    private static final String TAG = "MainActivity";
    ListContract.presenter presenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.jing)
    View jing;
    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new ListPresenterImpl(this);
        presenter.initData(recyclerview);
        setScrollListener(recyclerview);
    }


    @Override
    public void showList() {

    }

    @Override
    public void showEmpty() {

    }

    public void setScrollListener(RecyclerView rv){
        final int up_size = getResources().getDimensionPixelSize(R.dimen.up_size);
        rv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                temp+=dy;
                Log.e(TAG, "upsize="+up_size+"dy="+temp);
               if (temp>=up_size){
                   jing.setVisibility(View.VISIBLE);
               }else{

                   jing.setVisibility(View.INVISIBLE);
               }


            }
        });

    }
}
