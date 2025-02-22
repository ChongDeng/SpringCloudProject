package com.avistar.content.controllers;

import com.avistar.content.dao.content.ShareMapper;
import com.avistar.content.domain.entity.content.Share;
import com.avistar.user.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RefreshScope
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${scut.location}")
    private String scutLocation;

    @GetMapping("/location")
    public String location() {
        LOGGER.info("/location invoked");
        return this.scutLocation;
    }

    @Value("${scut.config}")
    private String scutConfig;

    @GetMapping("/test-config")
    public String scutConfig() {
        LOGGER.info("/test-config invoked");
        return this.scutConfig;
    }

    @RequestMapping("/test")
    public List<Share> test()
    {
        LOGGER.info("/test invoked");

        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("C++");
        share.setCover("Great, but waste time");
        share.setAuthor("scut");
        share.setBuyCount(2);

        shareMapper.insertSelective(share);

        List<Share> shares = shareMapper.selectAll();

        return shares;
    }

    @GetMapping("/test-rest-template/{userId}")
    public UserDTO test(@PathVariable Integer userId) {
        LOGGER.info("/est-rest-template invoked");

        return this.restTemplate
                .getForObject(
                        "http://user-center/users/{userId}",
                        UserDTO.class, userId);
    }
}
