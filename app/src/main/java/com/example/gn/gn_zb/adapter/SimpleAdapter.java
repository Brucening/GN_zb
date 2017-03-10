package com.example.gn.gn_zb.adapter;

import android.content.Context;

import com.example.gn.gn_zb.adapter.base.BaseAdapter;

import java.util.List;

/**
 * Created by GN on 2017/2/24.
 */

public abstract class SimpleAdapter<T> extends BaseAdapter<T,BaseViewHolder> {


    public SimpleAdapter(Context context, int layoutResId, List<T> datas) {
        super(context, layoutResId, datas);
    }
}
