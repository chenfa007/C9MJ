package com.c9mj.platform;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.utils.Utils;
import com.c9mj.platform.util.SpHelper;
import com.c9mj.platform.util.ToastUtil;
import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.squareup.leakcanary.LeakCanary;

/**
 * author: LMJ
 * date: 2016/9/6
 */
public class MyApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LeakCanary.install(this);
        Utils.init(context);
        ToastUtil.init(getApplicationContext());
        SpHelper.init(getApplicationContext());
        RxPaparazzo.register(this);
    }
}
