package com.alonginfo.servicconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private Integer port;
    // todo 4. 创建测试接口
    @GetMapping("hello")
    public String hello(@RequestParam String name){
        System.out.println(port);
        return "hello " + name+""+port;
    }
}
