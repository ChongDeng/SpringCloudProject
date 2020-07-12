package com.avistar.usercenter.controller.user;

import com.avistar.usercenter.dao.user.UserMapper;
import com.avistar.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

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
