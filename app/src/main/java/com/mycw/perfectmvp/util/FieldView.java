package com.mycw.perfectmvp.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：${changwei}
 * @function: 注解
 * @date: on 2018/1/15 10:51
 * E-Mail Address：1083467224@qq.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldView {
    int value();
}
