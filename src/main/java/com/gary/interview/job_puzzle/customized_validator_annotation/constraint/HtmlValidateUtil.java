/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.job_puzzle.customized_validator_annotation.constraint;

import com.gary.interview.job_puzzle.customized_validator_annotation.domain.Constants;

public class HtmlValidateUtil {

    public static boolean isValid(String str){
        System.out.println("enter isValid, str : " + str);
        if(Constants.ERROR_URL.equalsIgnoreCase(str)){
            return false;
        }else{
            return true;
        }
    }
}
