package com.alonginfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${test.common}")
    private String test_common;

    @GetMapping("/test-common")
    public String testcommon(){
        return test_common;
    }
}
