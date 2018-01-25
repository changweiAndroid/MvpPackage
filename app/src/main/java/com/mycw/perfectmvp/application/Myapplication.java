package com.mycw.perfectmvp.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/15 10:03
 * E-Mail Address：1083467224@qq.com
 */

public class Myapplication extends Application {


    private RefWatcher refWatcher;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = setupLeakCanary();
    }



    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        Myapplication leakApplication = (Myapplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
