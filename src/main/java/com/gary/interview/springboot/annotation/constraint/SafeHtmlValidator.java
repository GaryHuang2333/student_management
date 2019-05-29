/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.springboot.annotation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SafeHtmlValidator implements ConstraintValidator<SafeHtmlAnnotation, String> {
    private boolean required = false;

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        return HtmlValidateUtil.isValid(str);
    }

    @Override
    public void initialize(SafeHtmlAnnotation constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}
