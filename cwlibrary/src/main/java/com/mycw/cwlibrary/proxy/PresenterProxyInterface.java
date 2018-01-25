package com.mycw.cwlibrary.proxy;

import com.mycw.cwlibrary.factory.PresenterMvpFactory;
import com.mycw.cwlibrary.presenter.BaseMvpPresenter;
import com.mycw.cwlibrary.view.BaseMvpView;

/**
 * @author：${changwei}
 * @function:  代理接口
 * @date: on 2018/1/25 10:18
 * E-Mail Address：1083467224@qq.com
 */

public interface PresenterProxyInterface <V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return 返回PresenterMvpFactory类型
     */
    PresenterMvpFactory<V,P> getPresenterFactory();


    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     */
    P getMvpPresenter();

}
