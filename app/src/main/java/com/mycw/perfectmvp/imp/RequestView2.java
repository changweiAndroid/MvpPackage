package com.mycw.perfectmvp.imp;

import com.mycw.perfectmvp.appinfo.WeatherBean;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 11:24
 * E-Mail Address：1083467224@qq.com
 */
public interface RequestView2 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
