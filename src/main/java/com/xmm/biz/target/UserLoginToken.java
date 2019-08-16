package com.xmm.biz.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解,进入AuthenticationInterceptor拦截器中的登录token验证
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
    String powerName() default "";
}
