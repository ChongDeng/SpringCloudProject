package com.avistar.content.controller.content;

import com.avistar.auth.CheckLogin;
import com.avistar.content.domain.dto.content.ShareDTO;
import com.avistar.content.service.content.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
public class ShareConroller {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareConroller.class);

    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    @CheckLogin
    public ShareDTO findById(@PathVariable Integer id) {

        LOGGER.info("/id invoked");

        return shareService.findById(id);
    }
}
