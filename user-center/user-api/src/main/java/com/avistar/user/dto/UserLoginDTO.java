package com.avistar.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginDTO {

    private String name;

    private String email;

    private String avatarUrl;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
