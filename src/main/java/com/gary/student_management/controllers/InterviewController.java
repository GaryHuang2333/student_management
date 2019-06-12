/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.student_management.controllers;

import com.gary.interview.job_puzzle.customized_validator_annotation.domain.HtmlClass;
import com.gary.interview.job_puzzle.customized_validator_annotation.service.SafeHtmlServie;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InterviewController {
    SafeHtmlServie safeHtmlServie = new SafeHtmlServie();

    @PostMapping("/valid")
    public String valid(@Valid HtmlClass htmlClass){
        return "safe html : " + htmlClass;
    }

    @PostMapping("/validated")
    public String validated(@Validated HtmlClass htmlClass){
        return "safe html : " + htmlClass;
    }

    @PostMapping("/service/validated")
    public String serviceValidated( HtmlClass htmlClass){
        safeHtmlServie.validatedTest(htmlClass);
        return "safe html : " + htmlClass;
    }

    @PostMapping("/service/valid")
    public String serviceValid( HtmlClass htmlClass){
        safeHtmlServie.validTest(htmlClass);
        return "safe html : " + htmlClass;
    }
}
