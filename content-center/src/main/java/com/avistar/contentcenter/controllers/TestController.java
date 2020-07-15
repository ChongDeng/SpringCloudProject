package com.avistar.contentcenter.controllers;

import com.avistar.contentcenter.dao.content.ShareMapper;
import com.avistar.contentcenter.domain.entity.content.Share;
import com.avistar.usercenter.domain.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/test")
    public List<Share> test()
    {
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
        return this.restTemplate
                .getForObject(
                        "http://user-center/users/{userId}",
                        UserDTO.class, userId);
    }
}
