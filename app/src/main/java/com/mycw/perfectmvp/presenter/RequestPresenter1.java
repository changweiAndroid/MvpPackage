package com.mycw.perfectmvp.presenter;

import android.os.Handler;
import android.util.Log;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.imp.RequestView1;
import com.mycw.perfectmvp.mode.RequestMode1;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author：${changwei}
 * @function: p层 ,需要持有M 层和V层
 * @date: on 2018/1/23 22:15
 * E-Mail Address：1083467224@qq.com
 */

public class RequestPresenter1 {
    private final RequestView1 mRequestView;
    private final RequestMode1 mRequestMode;

    public RequestPresenter1(RequestView1 mRequestView) {
        this.mRequestView = mRequestView;
        this.mRequestMode = new RequestMode1();
    }

    public void clickRequest(final String cityId){

        mRequestView.requestLoading();
        //模拟耗时，可以展示出loading
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRequestMode.request(cityId, new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        mRequestView.resultSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        mRequestView.resultFailure(Log.getStackTraceString(t));
                    }
                });
            }
        },1000);

    }
}
