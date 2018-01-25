package com.mycw.perfectmvp.presenter;

import android.os.Handler;
import android.util.Log;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.base.AbstractMvpPersenter4;
import com.mycw.perfectmvp.imp.RequestView4;
import com.mycw.perfectmvp.mode.RequestMode4;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 17:11
 * E-Mail Address：1083467224@qq.com
 */
public class RequestPresenter4 extends AbstractMvpPersenter4<RequestView4> {
    private final RequestMode4 mRequestMode;

    public RequestPresenter4() {
        this.mRequestMode = new RequestMode4();
    }

    public void clickRequest(final String cityId){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRequestMode.request(cityId, new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        //判断View是否为空
                        if(getmMvpView() != null){
                            getmMvpView().resultSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        },1000);
    }
}
