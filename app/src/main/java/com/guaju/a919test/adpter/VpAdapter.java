package com.guaju.a919test.adpter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by guaju on 2017/9/22.
 */

public class VpAdapter extends PagerAdapter {
    List<ImageView> list;

    public VpAdapter(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //先判断当前控件有没有父容器 ，
        // 如果有，
        // 让父容器移除这个子控件，
        // 如果没有的话，就直接添加该子控件
        ImageView imageView = list.get(position);
        ViewParent view = imageView.getParent();
        ViewGroup parent = (ViewGroup) view;
        if (parent!=null){
            parent.removeView(imageView);
        }
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
