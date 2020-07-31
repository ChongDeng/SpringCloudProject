package com.avistar.user.controller.user;

import com.avistar.auth.CheckLogin;
import com.avistar.auth.JwtOperator;
import com.avistar.user.domain.entity.user.User;
import com.avistar.user.dto.JwtTokenRespDTO;
import com.avistar.user.dto.LoginRespDTO;
import com.avistar.user.bo.UserLoginBO;
import com.avistar.user.dto.UserRespDTO;
import com.avistar.user.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "用户操作 API")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    private final JwtOperator jwtOperator;

    @ApiOperation(
            value = "查询id",
            notes = "根据参数来构建",
            produces="application/json",
            consumes="application/json",
            response = User.class)
    @GetMapping("/{id}")
    @CheckLogin
    public User findById(@PathVariable Integer id) {
        LOGGER.info("/id invoked");
        //log.info("我被请求了...");
        return userService.findById(id);
    }

    @ApiOperation(
            value = "登录",
            notes = "根据参数来构建",
            produces="application/json",
            consumes="application/json",
            response = LoginRespDTO.class)
    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody UserLoginBO userLoginBO) {

        LOGGER.info("/login invoked");

        // 看用户是否注册，如果没有注册就（插入）
        // 如果已经注册
        User user = this.userService.login(userLoginBO);

        // 颁发token
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id", user.getId());
        userInfo.put("wxNickname", user.getWxNickname());
        userInfo.put("role", user.getRoles());

        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "用户{}登录成功，生成的token = {}, 有效期到:{}",
                userLoginBO.getWxNickname(),
                token,
                jwtOperator.getExpirationTime()
        );

        // 构建响应
        return LoginRespDTO.builder()
                .user(
                        UserRespDTO.builder()
                                .id(user.getId())
                                .avatarUrl(user.getAvatarUrl())
                                .bonus(user.getBonus())
                                .wxNickname(user.getWxNickname())
                                .build()
                )
                .token(
                        JwtTokenRespDTO.builder()
                                .expirationTime(jwtOperator.getExpirationTime().getTime())
                                .token(token)
                                .build()
                )
                .build();
    }

    /**
     * 模拟生成token(假的登录)
     */
    @ApiOperation(
            value = "模拟生成token",
            notes = "根据参数来构建",
            produces="application/json",
            consumes="application/json",
            response = LoginRespDTO.class)
    @GetMapping("/genToken")
    public String genToken() {
        LOGGER.info("/genToken invoked");

        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id", 1);
        userInfo.put("wxNickname", "fqyang");
        userInfo.put("role", "admin");
        return jwtOperator.generateToken(userInfo);
    }

}
