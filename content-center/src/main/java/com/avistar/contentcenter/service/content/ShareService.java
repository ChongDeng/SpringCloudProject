package com.avistar.contentcenter.service.content;


import com.avistar.contentcenter.dao.content.ShareMapper;
import com.avistar.contentcenter.domain.dto.content.ShareDTO;
import com.avistar.contentcenter.domain.entity.content.Share;
import com.avistar.contentcenter.feignclient.UserCenterFeignClient;
import com.avistar.usercenter.domain.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserCenterFeignClient userCenterFeignClient;

    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = shareMapper.selectByPrimaryKey(id);

        // 发布人id
        Integer userId = share.getUserId();


        // HTTP GET; User类能自动换砖为UserDTO类！！！
//        UserDTO userDTO = restTemplate.getForObject(
//                "http://user-center/users/{id}",
//                UserDTO.class, 1
//        );

        UserDTO userDTO = userCenterFeignClient.findById(1);

        ShareDTO shareDTO = new ShareDTO();
        // 消息的装配
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());

        return shareDTO;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        // 用HTTP GET方法去请求，并且返回一个对象
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:8081/users/{id}",
                String.class, 2
        );

        System.out.println(forEntity.getBody());
        // 200 OK
        // 500
        // 502 bad gateway...
        System.out.println(forEntity.getStatusCode());
    }

}

