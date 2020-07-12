package com.avistar.contentcenter.controller.content;

import com.avistar.contentcenter.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
public class ShareConroller {
    @Autowired
    private ShareService shareService;

}
