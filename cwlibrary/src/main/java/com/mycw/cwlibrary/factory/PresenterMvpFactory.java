package com.mycw.cwlibrary.factory;

import com.mycw.cwlibrary.presenter.BaseMvpPresenter;
import com.mycw.cwlibrary.view.BaseMvpView;

/**
 * @author：${changwei}
 * @function: Presenter工厂接口
 * @date: on 2018/1/25 10:16
 * E-Mail Address：1083467224@qq.com
 */

public interface PresenterMvpFactory <V extends BaseMvpView,P extends BaseMvpPresenter<V>>{
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
