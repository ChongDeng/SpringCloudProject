package com.avistar.contentcenter.controllers;

import com.avistar.contentcenter.dao.content.ShareMapper;
import com.avistar.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ShareMapper shareMapper;

    @RequestMapping("/test")
    public List<Share> test()
    {
        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("spring");
        share.setCover("Cool");
        share.setAuthor("fqyang");
        share.setBuyCount(5);

        shareMapper.insertSelective(share);

        List<Share> shares = shareMapper.selectAll();

        return shares;
    }
}
