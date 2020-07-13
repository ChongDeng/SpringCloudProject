package com.avistar.contentcenter.feignclient;

import com.avistar.contentcenter.configuration.UserCenterlFeignConfiguration;
import com.avistar.usercenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-center", configuration = GlobalFeignConfiguration.class)
//@FeignClient(name = "user-center", configuration = UserCenterlFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {
    /**
     * http://user-center/users/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);
}
