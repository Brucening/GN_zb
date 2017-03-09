package com.example.gn.gn_zb.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gn.gn_zb.R;
import com.example.gn.gn_zb.fragment.base.BaseFragmet;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class FragmentHot extends BaseFragmet {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_hot,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInsta) {

        return null;
    }

}
