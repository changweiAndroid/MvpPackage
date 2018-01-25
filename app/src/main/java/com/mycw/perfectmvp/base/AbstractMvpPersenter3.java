package com.mycw.perfectmvp.base;

/**
 * @author：${changwei}
 * @function: MVP架构中所有Presenter的基类
 * @date: on 2018/1/24 14:55
 * E-Mail Address：1083467224@qq.com
 */
public abstract class AbstractMvpPersenter3<V extends MvpView> {
    /**
     * V层引用
     */
    private V mMvpView;

    /**
     * 绑定V层
     *
     * @param v
     */
    public void attachMvpView(V v) {
        this.mMvpView = v;
    }

    /**
     * 解除绑定V层
     */
    public void detachMvpView() {
        this.mMvpView = null;
    }

    /**
     * 获取V层引用
     *
     * @return 返回V层
     */
    public V getMvpView() {
        return mMvpView;
    }
}
