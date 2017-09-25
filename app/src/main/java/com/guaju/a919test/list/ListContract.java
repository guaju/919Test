package com.guaju.a919test.list;

import android.support.v7.widget.RecyclerView;

/**
 * Created by guaju on 2017/9/21.
 */

public interface ListContract {
    interface  View{
      void  showList();
      void  showEmpty();

    }
    interface presenter{
      void initData(RecyclerView rv);
      void initAdapter(RecyclerView rv);

    }
}
