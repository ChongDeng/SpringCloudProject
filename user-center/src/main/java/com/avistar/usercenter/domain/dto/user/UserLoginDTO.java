package com.avistar.usercenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
