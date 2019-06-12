/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.job_puzzle.customized_validator_annotation.service;

import com.gary.interview.job_puzzle.customized_validator_annotation.domain.HtmlClass;
import org.junit.Test;


public class SafeHtmlServieTest {
    SafeHtmlServie servie = new SafeHtmlServie();

    @Test
    public void validateHtml() {
        HtmlClass html = new HtmlClass("url_attack", "test_website");
    }
}


