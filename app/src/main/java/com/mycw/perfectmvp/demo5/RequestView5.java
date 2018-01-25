package com.mycw.perfectmvp.demo5;

import com.mycw.cwlibrary.view.BaseMvpView;
import com.mycw.perfectmvp.appinfo.WeatherBean;

/**
 * @author：${changwei}
 * @function:
 * @date: on 2018/1/25 14:29
 * E-Mail Address：1083467224@qq.com
 */
public interface RequestView5 extends BaseMvpView {
    void requestLoading();

    void resultSuccess(WeatherBean result);

    void resultFailure(String result);
}
