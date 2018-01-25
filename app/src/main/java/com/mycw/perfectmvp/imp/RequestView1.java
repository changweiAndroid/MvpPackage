package com.mycw.perfectmvp.imp;

import com.mycw.perfectmvp.appinfo.WeatherBean;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/23 22:15
 * E-Mail Address：1083467224@qq.com
 */

public interface RequestView1 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
