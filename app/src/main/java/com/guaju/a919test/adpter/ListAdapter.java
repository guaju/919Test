package com.guaju.a919test.adpter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guaju.a919test.R;
import com.guaju.a919test.bean.DetailBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guaju on 2017/9/21.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int TYPE_VP = 100;
    final int TYPE_FIX = 101;
    final int TYPE_NORMAL = 102;
    //声明一个imageview的集合
    ArrayList<ImageView>  imageLists=new ArrayList<>();
    Context context;
    List list;
    private  static LayoutInflater inflater;

    public ListAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh=null;
        switch (viewType) {
            case TYPE_VP:
                View view1 = inflater.inflate(R.layout.item_vp, parent, false);
                 vh = new VPViewHolder(view1);
                break;
            case TYPE_FIX:
                View view2 = inflater.inflate(R.layout.item_fix, null, false);
                 vh = new FixedViewHolder(view2);
                break;
            case TYPE_NORMAL:
                View view3 = inflater.inflate(R.layout.item_list, null, false);
                vh =new NormalViewHolder(view3);
                break;
        }
       return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          if (holder instanceof VPViewHolder){
              VPViewHolder vpHolder = (VPViewHolder) holder;
              ArrayList<Integer> intLists = (ArrayList<Integer>) list.get(0);
              for (Integer i:intLists){
                  ImageView imageView = new ImageView(context);
                  imageView.setBackgroundResource(i);
                  imageLists.add(imageView);
              }
              vpHolder.setContent(imageLists);
          }
          else if (holder instanceof FixedViewHolder){
              FixedViewHolder fHolder = (FixedViewHolder) holder;
              DetailBean detailBean = (DetailBean) list.get(1);
              fHolder.setContent(detailBean);
          }
          else{
              NormalViewHolder nHolder = (NormalViewHolder) holder;
              ArrayList<String> lists = (ArrayList<String>) list.get(2);
              nHolder.setContent(lists,position-2);  //去除前面两个的位置
          }
    }
    @Override
    public int getItemCount() {
        ArrayList<String> lists = (ArrayList<String>) list.get(2);
        return 2+ lists.size();//总长度
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_VP;
        } else if (position == 1) {
            return TYPE_FIX;
        } else {
            return TYPE_NORMAL;
        }

    }
    //创建三个viewholder 用来展示

    /**
     * 1.viewpager的
     */

    public static class VPViewHolder extends RecyclerView.ViewHolder {
       static VPViewHolder vpViewHolder;
        @BindView(R.id.vp)
        ViewPager vp;

        private VPViewHolder(View itemView) {
            super(itemView);
            //%%%%%butterknife如果使用在适配器中，用两个参数的绑定方法
            ButterKnife.bind(this,itemView);
        }


            //设置viewpager的内容
        public void setContent(List<ImageView> list) {
            VpAdapter vpAdapter = new VpAdapter(list);
            vp.setAdapter(vpAdapter);
        }
    }

    //固定布局的viewholder
    public  class FixedViewHolder extends RecyclerView.ViewHolder{
         FixedViewHolder fixedVH;
        @BindView(R.id.imageView)
        ImageView iv;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.time)
        TextView time;



        private FixedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }

        //设置viewpager的内容
        public  void setContent(DetailBean bean){
            iv.setBackgroundResource(bean.getIconID());
            title.setText(bean.getTitle());
            desc.setText(bean.getDesc());
            time.setText(bean.getTime());
        }

    }


    public static class NormalViewHolder extends RecyclerView.ViewHolder{
        NormalViewHolder  nVh;
        @BindView(R.id.tv_list)
        TextView tv_list;

        private NormalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public  void  setContent(ArrayList<String> lists,int position){
             tv_list.setText(lists.get(position));
        }

    }

}
