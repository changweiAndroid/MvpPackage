package com.mycw.perfectmvp.imp;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.base.MvpView;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 13:39
 * E-Mail Address：1083467224@qq.com
 */
public interface RequestView3 extends MvpView {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
