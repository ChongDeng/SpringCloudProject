package com.avistar.content.controller.content;

import com.avistar.auth.CheckLogin;
import com.avistar.content.domain.dto.content.ShareDTO;
import com.avistar.content.service.content.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
@Api(value = "内容操作 API")
public class ShareConroller {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareConroller.class);

    @Autowired
    private ShareService shareService;

    @ApiOperation(
            value = "查询分享",
            notes = "根据参数来构建",
            produces="application/json",
            consumes="application/json",
            response = ShareDTO.class)
    @GetMapping("/{id}")
    @CheckLogin
    public ShareDTO findById(@PathVariable Integer id) {

        LOGGER.info("/id invoked");

        return shareService.findById(id);
    }
}
