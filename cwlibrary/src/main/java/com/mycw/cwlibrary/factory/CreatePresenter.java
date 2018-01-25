package com.mycw.cwlibrary.factory;

import com.mycw.cwlibrary.presenter.BaseMvpPresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author：${changwei}
 * @function: 标注创建Presenter的注解
 * @date: on 2018/1/25 10:16
 * E-Mail Address：1083467224@qq.com
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BaseMvpPresenter> value();
}
