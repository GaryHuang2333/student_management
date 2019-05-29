/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.springboot.annotation.constraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * springboot-No6 : 校验的引入 @Constraint和自定义注解进行校验策略的设计模式浅谈
 * https://blog.csdn.net/fk002008/article/details/80034256
 */

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {SafeHtmlValidator.class})
public @interface SafeHtmlAnnotation {
    boolean required() default true;

    String message() default "html error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
//@Target({METHOD, FIELD, PARAMETER})
