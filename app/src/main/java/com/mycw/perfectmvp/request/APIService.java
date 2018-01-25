package com.mycw.perfectmvp.request;

import com.mycw.perfectmvp.appinfo.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author：${changwei}
 * @function: 请求接口
 * @date: on 2018/1/23 15:55
 * E-Mail Address：1083467224@qq.com
 */

public interface APIService {
    /**
     * 请求天气接口
     *
     * @param cityId 城市
     * @return Call
     */
    @GET("data/cityinfo/{cityId}.html")
    Call<WeatherBean> requestWeather(@Path("cityId") String cityId);
}