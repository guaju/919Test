package com.guaju.a919test.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guaju.a919test.R;
import com.guaju.a919test.adpter.ListAdapter;
import com.guaju.a919test.bean.DetailBean;

import java.util.ArrayList;

/**
 * Created by guaju on 2017/9/21.
 */

public class ListPresenterImpl implements ListContract.presenter {
    ListContract.View view;
    ArrayList list=new ArrayList();
    private final MainActivity mainActivity;
    public ListPresenterImpl(ListContract.View view) {
        this.view = view;
        mainActivity = (MainActivity) view;
    }
    //初始化recyclerview的数据
    @Override
    public void initData(RecyclerView rv) {
        //构造数据
        ArrayList<Integer> strings = new ArrayList<>(4);
        strings.add(R.mipmap.ic_launcher);
        strings.add(R.mipmap.ic_launcher);
        strings.add(R.mipmap.ic_launcher);
        strings.add(R.mipmap.ic_launcher);
        list.add(strings);

        //设置固定布局的数据
        DetailBean dBean = new DetailBean(R.mipmap.ic_launcher, "hehhehe", "你好，我是描述", "2020年2月20");
        list.add(dBean);
        ArrayList<String> lists = new ArrayList<>(20);
        for (int i=0;i<20;i++){
        lists.add("你好哈哈哈哈哈"+i);
        }
        list.add(lists);
        initAdapter(rv);
    }

    //给recyclerview设置适配器
    @Override
    public void initAdapter(RecyclerView rv) {
        ListAdapter listAdapter = new ListAdapter(mainActivity, list);
        rv.setLayoutManager(new LinearLayoutManager(mainActivity));
        rv.setAdapter(listAdapter);
    }
}
