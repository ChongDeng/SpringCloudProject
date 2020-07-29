package com.avistar.content.controller.content;

import com.avistar.content.auth.CheckAuthorization;
import com.avistar.content.auth.CheckLogin;
import com.avistar.content.domain.dto.content.ShareDTO;
import com.avistar.content.service.content.ShareService;
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
