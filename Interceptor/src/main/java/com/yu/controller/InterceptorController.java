package com.yu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Classname InterceptorController
 * @Date 2021/2/18 11:45
 * @Created by yufx
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/run")
    public void run() {
        System.out.println("Hello Word");
    }

}

