package cn.tellsea.walnut.aop.annotation;

import java.lang.annotation.*;

/**
 * 登录日志自定义注解
 *
 * @author Tellsea
 * @date 2019/7/17
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginLog {

}
