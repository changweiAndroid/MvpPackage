package com.mycw.perfectmvp.imp;

import com.mycw.perfectmvp.appinfo.WeatherBean;
import com.mycw.perfectmvp.base.IMvpBaseView4;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/24 17:09
 * E-Mail Address：1083467224@qq.com
 */
public interface RequestView4  extends IMvpBaseView4 {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
