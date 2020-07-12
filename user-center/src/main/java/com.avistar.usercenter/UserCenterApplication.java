package com.avistar.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

//扫描mybatis哪些包里面的接口
@MapperScan("com.avistar.usercenter.dao")
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    // 在spring容器中，创建一个对象，类型RestTemplate；名称/ID是：restTemplate
    // <bean id="restTemplate" class="xxx.RestTemplate"/>
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
