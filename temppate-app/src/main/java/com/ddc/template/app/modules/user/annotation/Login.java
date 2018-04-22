package com.ddc.template.app.modules.user.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 * @author harry.zhang
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
