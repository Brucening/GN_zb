package com.example.gn.gn_zb.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gn.gn_zb.adapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GN on 2017/2/22.
 */

public abstract class BaseAdapter<T,H extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder>{
    protected final Context mContext;
    protected int mLayoutResId;
    protected List<T> mDatas;
    private T item;
    private OnItemClickListener mOnItemClickListener=null;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public BaseAdapter(Context context, int layoutResId, List<T> datas){
        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mDatas = datas == null ? new ArrayList<T>() : datas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutResId,parent,false);
        return new BaseViewHolder(view,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T item = getItem(position);
        convert((H)holder,item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //得到泛型类型
    public T getItem(int position){
        return position >= mDatas.size() ? null : mDatas.get(position);
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int psition);
    }

    protected abstract void convert(H holder, T item);

    //添加数据
    public void addData(List<T> list){
        addData(0,list);
        Log.e("TAG","添加的集合=="+list);
    }

    public void addData(int position,List<T> list){
        if(list !=null && list.size()>=0){
            mDatas.addAll(list);
            notifyItemRangeChanged(position,mDatas.size());
        }
    }

    //清空数据源
    public void clearData(){
        int i = mDatas.size();
        mDatas.clear();
        notifyItemRangeChanged(0,i);
    }

    public void refreshData(List<T> list){
        if(list!=null&&list.size()>0){
            clearData();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                mDatas.add(i,list.get(i));
                notifyItemInserted(i);
            }
        }
    }

    public void loadMoreData(List<T> list){
        if(list != null && list.size()>0){
            int size = list.size();
            int begin = mDatas.size();
            for (int i = 0; i < size; i++) {
                mDatas.add(list.get(i));
                notifyItemInserted(i+begin);
            }
        }
    }


}
