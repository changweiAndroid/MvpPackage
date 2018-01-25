package com.mycw.perfectmvp.base;

/**
 * @author：${changwei}
 * @function: 指定绑定的View必须继承自IMvpBaseView4
 * @date: on 2018/1/24 17:13
 * E-Mail Address：1083467224@qq.com
 */
public class AbstractMvpPersenter4<V extends IMvpBaseView4> {
    private V mMvpView;
    /**
     * 绑定V层
     * @param view
     */
    public void attachMvpView(V view){
        this.mMvpView = view;
    }

    /**
     * 解除绑定V层
     */
    public void detachMvpView(){
        mMvpView = null;
    }
    /**
     * 获取V层
     * @return
     */
    public V getmMvpView() {
        return mMvpView;
    }
}
