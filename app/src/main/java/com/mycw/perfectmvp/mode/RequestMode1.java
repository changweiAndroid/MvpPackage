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
 * @function: M层 数据层
 * @date: on 2018/1/23 22:25
 * E-Mail Address：1083467224@qq.com
 */

public class RequestMode1 {
    private static final String BASE_URL = "http://www.weather.com.cn/";

    //http://www.weather.com.cn/data/cityinfo/101010100.html
    public void request(String detailId, Callback<WeatherBean> callback){
        //请求接口
        Retrofit retrofit  = new Retrofit.Builder()
                //代表root地址
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService =retrofit.create(APIService.class);
        //请求
        Call<WeatherBean> weatherBeanCall = apiService.requestWeather(detailId);

        weatherBeanCall.enqueue(callback);

    }
}
