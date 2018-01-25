package com.mycw.perfectmvp.mode;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.request.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 17:28
 * E-Mail Address：1083467224@qq.com
 */
public class RequestMode4 {
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private Call<WeatherBean> weatherBeanCall;

    public void request(String cityId, Callback<WeatherBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        weatherBeanCall = apiService.requestWeather(cityId);
        weatherBeanCall.enqueue(callback);
    }
}
