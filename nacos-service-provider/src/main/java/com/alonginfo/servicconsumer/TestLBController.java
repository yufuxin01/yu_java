package com.alonginfo.servicconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/1 18:39
 */
@RestController
public class TestLBController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;
    @GetMapping("/testlb")
    public String testlb(@RequestParam String name){
        String result = restTemplate.getForObject("http://service-provider/hello?name" + name+" "+port, String.class);
        return result;
    }
}
