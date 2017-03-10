package com.example.gn.gn_zb.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.example.gn.gn_zb.R;
import com.example.gn.gn_zb.adapter.HWAdapter;
import com.example.gn.gn_zb.adapter.base.BaseAdapter;
import com.example.gn.gn_zb.adapter.base.DividerItemDecoration;
import com.example.gn.gn_zb.entity.PageResult;
import com.example.gn.gn_zb.entity.Wares;
import com.example.gn.gn_zb.fragment.base.BaseFragmet;
import com.example.gn.gn_zb.http.Contants;
import com.example.gn.gn_zb.utils.PageUtils;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class FragmentHot extends BaseFragmet {
    @BindView(R.id.hot_rv)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    MaterialRefreshLayout mRefreshLayout;

    private HWAdapter hwAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_hot,container,false);
        ButterKnife.bind(this,view);

        PageUtils pageUtils = PageUtils.newBuilder()
                .setUrl(Contants.API.FAVORITEINFO)
                .setLoadMore(true)
                .setOnPageListener(new PageUtils.onPageListener() {
                    @Override
                    public void load(List datas, int totalPage, int totalCount) {
                        hwAdapter = new HWAdapter(getActivity(),datas);
                        hwAdapter.setmOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int psition) {
                                Toast.makeText(getContext(),"点击成功！！！",Toast.LENGTH_LONG).show();
                            }
                        });
                        recyclerView.setAdapter(hwAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.addItemDecoration(new DividerItemDecoration(
                                getContext(),DividerItemDecoration.VERTICAL_LIST
                        ));

                    }

                    @Override
                    public void refresh(List datas, int totalPage, int totalCount) {
                        hwAdapter.clearData();
                        hwAdapter.addData(datas);
                        recyclerView.scrollToPosition(0);
                    }

                    @Override
                    public void loadMore(List datas, int totalPage, int totalCount) {
                        hwAdapter.addData(hwAdapter.getItemCount(),datas);
                        recyclerView.scrollToPosition(hwAdapter.getItemCount());

                    }
                })
                .setPageSize(20)
                .setRefreshLayout(mRefreshLayout)
                .build(getActivity(),new TypeToken<PageResult<Wares>>(){}.getType());
        pageUtils.request();


        return view;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInsta) {

        return null;
    }

}
