package com.avistar.contentcenter.controller.content;

import com.avistar.contentcenter.auth.CheckAuthorization;
import com.avistar.contentcenter.auth.CheckLogin;
import com.avistar.contentcenter.domain.dto.content.ShareDTO;
import com.avistar.contentcenter.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareAdminController {

    private final ShareService shareService;

    @GetMapping("/{id}")
    @CheckLogin
    @CheckAuthorization("admin")
    public ShareDTO findById(@PathVariable Integer id) {
        return shareService.findById(id);
    }

}
