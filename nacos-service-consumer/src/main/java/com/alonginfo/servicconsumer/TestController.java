package com.alonginfo.servicconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// todo 5. 发起服务调用

@RestController
public class TestController {
    // 引入 RestTemplate
    @Autowired
    RestTemplate restTemplate;

    // 引入 LoadBalancerClient
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        String result = "";

        result = restTemplate.getForObject("http://service-provider/hello?name=test", String.class);

        // 返回结果
        return result;
    }
}
