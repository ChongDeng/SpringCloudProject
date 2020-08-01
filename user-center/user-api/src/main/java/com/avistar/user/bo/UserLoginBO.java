package com.avistar.user.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@ApiModel(value = "UserLoginBO", description = "用户登录参数")
public class UserLoginBO {

    @ApiModelProperty(value = "用户姓名 0:lilei 1:hanmeimei", required = true, example = "tom")
    private String name;

    private String email;

    private String avatarUrl;

    /**
     * 微信昵称
     */
    private String wxNickname;
}
