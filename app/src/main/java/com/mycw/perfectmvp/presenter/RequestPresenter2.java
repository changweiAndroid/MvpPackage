package com.mycw.perfectmvp.presenter;

import android.os.Handler;
import android.util.Log;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.imp.RequestView2;
import com.mycw.perfectmvp.mode.RequestMode2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 11:27
 * E-Mail Address：1083467224@qq.com
 */
public class RequestPresenter2 {
    private RequestView2 requestView2;
    private RequestMode2 requestMode2;

    public RequestPresenter2() {
        requestMode2 = new RequestMode2();
    }

    public void clickRequest(final String cityId) {
        if (requestView2 != null) {
            requestView2.requestLoading();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    requestMode2.request(cityId, new Callback<WeatherBean>() {
                        @Override
                        public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                            if(requestView2 != null){
                                requestView2.resultSuccess(response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<WeatherBean> call, Throwable t) {
                            if(requestView2 != null){
                                requestView2.resultFailure(Log.getStackTraceString(t));
                            }
                        }
                    });
                }
            }, 1000);

        }
    }

    /**
     * 绑定
     *
     * @param requestView2
     */
    public void attach(RequestView2 requestView2) {
        this.requestView2 = requestView2;
    }

    /**
     * 解绑
     */
    public void detach() {
        requestView2 = null;
    }

    /**
     * 取消网络请求
     */
    public void interruptHttp() {
        requestMode2.interruptHttp();
    }

}
