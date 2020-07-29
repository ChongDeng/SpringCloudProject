package com.avistar.user.controller.user;

import com.avistar.user.dao.user.UserMapper;
import com.avistar.user.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Value("${scut.location}")
    private String scutLocation;

    @GetMapping("/location")
    public String scutLocation() {
        return this.scutLocation;
    }

    @Value("${ext_val.name}")
    private String ext;

    @GetMapping("/ext")
    public String ext() {
        return this.ext;
    }

    @RequestMapping("/test")
    public User test()
    {
        User user = new User();
        user.setAvatarUrl("YYY");
        user.setBonus(200);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        userMapper.insertSelective(user);

        return user;
    }
}
