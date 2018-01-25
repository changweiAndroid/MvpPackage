package com.mycw.perfectmvp.demo5;

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
 * @date: on 2018/1/25 14:37
 * E-Mail Address：1083467224@qq.com
 */
public class RequestMode5 { private static final String BASE_URL = "http://www.weather.com.cn/";
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

    public void interruptHttp(){
        if(weatherBeanCall != null && !weatherBeanCall.isCanceled()){
            weatherBeanCall.cancel();
        }
    }
}
