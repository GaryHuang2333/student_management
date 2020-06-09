/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


package com.gary.student_management.exceptions;

import com.gary.student_management.responses.IResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(BaseException.class);

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(String.valueOf(responseEnum.getCode()));
        String className = this.getClass().getSimpleName();
        String printMsg = "Class[" + className + "] Message[" + message + "] Response[" + responseEnum.getCode() + "|" + responseEnum.getMessage() + "]";
        logger.debug(printMsg);
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(String.valueOf(responseEnum.getCode()));
        String className = this.getClass().getSimpleName();
        String printMsg = "Class[" + className + "] Message[" + message + "] Response[" + responseEnum.getCode() + "|" + responseEnum.getMessage() + "]";
        logger.debug(printMsg);
    }
}
