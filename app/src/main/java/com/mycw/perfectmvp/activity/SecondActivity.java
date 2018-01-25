package com.mycw.perfectmvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mycw.cwlibrary.factory.CreatePresenter;
import com.mycw.cwlibrary.view.AbstractMvpActivitiy;
import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.application.Myapplication;
import com.mycw.perfectmvp.demo5.RequestPresenter5;
import com.mycw.perfectmvp.demo5.RequestView5;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/25 14:28
 * E-Mail Address：1083467224@qq.com
 */
@CreatePresenter(RequestPresenter5.class)
public class SecondActivity extends AbstractMvpActivitiy<RequestView5, RequestPresenter5> implements RequestView5{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(WeatherBean result) {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = Myapplication.getRefWatcher(this);//1
        refWatcher.watch(this);
    }
}
