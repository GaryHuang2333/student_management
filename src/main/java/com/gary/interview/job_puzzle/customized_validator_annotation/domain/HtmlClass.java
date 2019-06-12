/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.job_puzzle.customized_validator_annotation.domain;

import com.gary.interview.job_puzzle.customized_validator_annotation.constraint.SafeHtmlAnnotation;

public class HtmlClass {

    @SafeHtmlAnnotation
    private String url;

    private String websiteName;

    public HtmlClass(String url, String websiteName) {
        this.url = url;
        this.websiteName = websiteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public String toString() {
        return "HtmlClass{" +
                "url='" + url + '\'' +
                ", websiteName='" + websiteName + '\'' +
                '}';
    }
}

