package com.avistar.usercenter.service.user;

import com.avistar.usercenter.dao.user.UserMapper;
import com.avistar.usercenter.domain.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        // select * from user where id = #{id}
        return userMapper.selectByPrimaryKey(id);
    }


}
