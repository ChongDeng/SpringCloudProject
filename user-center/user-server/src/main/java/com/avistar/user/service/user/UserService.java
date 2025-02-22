package com.avistar.user.service.user;

import com.avistar.user.dao.user.UserMapper;
import com.avistar.user.domain.entity.user.User;
import com.avistar.user.bo.UserLoginBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        // select * from user where id = #{id}
        return userMapper.selectByPrimaryKey(id);
    }

    public User login(UserLoginBO loginDTO){

        User user = this.userMapper.selectOne(
                User.builder()
                        .wxNickname(loginDTO.getWxNickname())
                        .build()
        );

        if (user == null) {
            User userToSave = User.builder()
                    .wxId("random")
                    .bonus(300)
                    .wxNickname(loginDTO.getWxNickname())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .roles("user")
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            this.userMapper.insertSelective(
                    userToSave
            );
            return userToSave;
        }
        return user;
    }


}
