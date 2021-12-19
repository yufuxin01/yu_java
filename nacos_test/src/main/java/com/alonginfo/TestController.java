package com.alonginfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${test.name}")
    private String testName;

    @GetMapping("/testconfig")
    public String testConfig()
    {
        return testName;
    }
}
