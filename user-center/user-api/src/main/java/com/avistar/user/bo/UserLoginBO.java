package com.avistar.user.bo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginBO {

    private String name;

    private String email;

    private String avatarUrl;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
