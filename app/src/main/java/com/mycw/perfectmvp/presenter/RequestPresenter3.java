package com.mycw.perfectmvp.presenter;

import android.os.Handler;
import android.util.Log;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.base.AbstractMvpPersenter3;
import com.mycw.perfectmvp.imp.RequestView3;
import com.mycw.perfectmvp.mode.RequestMode3;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 14:39
 * E-Mail Address：1083467224@qq.com
 */
public class RequestPresenter3 extends AbstractMvpPersenter3<RequestView3> {
    private RequestMode3 mRequestMode;

    public RequestPresenter3() {
        mRequestMode = new RequestMode3();
    }

    public void clickRequest(final String cityId) {
        if (getMvpView() != null) {
            getMvpView().requestLoading();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRequestMode.request(cityId, new Callback<WeatherBean>() {
                        @Override
                        public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                            if (getMvpView() != null) {
                                getMvpView().resultSuccess(response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<WeatherBean> call, Throwable t) {
                            if (getMvpView() != null) {
                                getMvpView().resultFailure(Log.getStackTraceString(t));
                            }
                        }
                    });

                }
            }, 1000);

        }
    }

    public void interruptHttp(){
        if(mRequestMode != null){
            mRequestMode.interruptHttp();
        }
    }
}
