package com.avistar.content.controller.content;

import com.avistar.auth.CheckAuthorization;
import com.avistar.auth.CheckLogin;
import com.avistar.content.controllers.TestController;
import com.avistar.content.domain.dto.content.ShareDTO;
import com.avistar.content.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareAdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareAdminController.class);

    private final ShareService shareService;

    @GetMapping("/{id}")
    @CheckLogin
    @CheckAuthorization("admin")
    public ShareDTO findById(@PathVariable Integer id) {
        LOGGER.info("/id invoked");
        return shareService.findById(id);
    }

}
