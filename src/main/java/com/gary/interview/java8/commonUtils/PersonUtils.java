/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.commonUtils;

import static com.gary.interview.java8.commonUtils.PersonConstants.AGE_ADULT;
import static com.gary.interview.java8.commonUtils.PersonConstants.AGE_ELDER;

public class PersonUtils {

    public static String ageRangeCheck(int age) {
        if (AGE_ADULT <= age && AGE_ELDER > age) {
            return "ADULT";
        } else if (AGE_ADULT > age) {
            return "CHILD";
        } else if (AGE_ELDER <= age) {
            return "ELDER";
        } else {
            return "INVALID";
        }
    }
}
