package com.alonginfo.servicconsumer;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/1 14:38
 */
@Configuration
public class ConsumerConfig {
    // todo 4. 配置 RestTemplate
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*
        负载均衡
     */
    @Bean
    public IRule iRule(){
        // 随机策略
//        return new RandomRule();
        //权重 越大几率越大
        return new NacosWeightRule();
    }

}

