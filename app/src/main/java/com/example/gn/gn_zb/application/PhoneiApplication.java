package com.example.gn.gn_zb.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by GN on 2017/2/23.
 */

public class PhoneiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //基本使用的初始化方法
        Fresco.initialize(this);
    }
}

