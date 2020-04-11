package com.cmbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auther: 张夫业
 * @Date: 2020/4/6
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface AnnoDemo01 {
    String className();
    String method();
}
