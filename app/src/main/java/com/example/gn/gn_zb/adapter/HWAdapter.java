package com.example.gn.gn_zb.adapter;

import android.content.Context;
import android.net.Uri;

import com.example.gn.gn_zb.R;
import com.example.gn.gn_zb.entity.Wares;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by GN on 2017/3/9.
 */

public class HWAdapter extends SimpleAdapter<Wares>{

    public HWAdapter(Context context, List<Wares> datas) {
        super(context, R.layout.fragment_sift_item, datas);
    }

    @Override
    protected void convert(BaseViewHolder holder, Wares item) {
        holder.getButton(R.id.bt_status).setText(item.getStatus());
        holder.getTextView(R.id.text_xing).setText(item.getName());
        holder.getTextView(R.id.text_di).setText(item.getPlace());

        SimpleDraweeView draweeView = (SimpleDraweeView) holder.getView(R.id.sift_wares_img_sdv);
//        CircleImageView draweeView = (CircleImageView) holder.getView(R.id.sift_wares_img_sdv);
        draweeView.setImageURI(Uri.parse(item.getHeadIcon()));
        draweeView = (SimpleDraweeView) holder.getView(R.id.img_fm);
        draweeView.setImageURI(Uri.parse(item.getInformationImage()));

    }

    public void resetLayout(int layout){
        this.mLayoutResId = layout;
        notifyItemRangeChanged(0,getItemCount());
    }
}
