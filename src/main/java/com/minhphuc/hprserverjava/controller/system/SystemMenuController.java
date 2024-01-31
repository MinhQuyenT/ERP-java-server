package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemMenu;
import com.minhphuc.hprserverjava.service.system.SystemMenuService;
import com.minhphuc.hprserverjava.util.MessageResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "2. API quản lý menu hệ thống")
@RestController
@RequestMapping("/api/v1/systemMenu")
@RequiredArgsConstructor
public class SystemMenuController {

    private final SystemMenuService systemMenuService;

    @GetMapping("")
    public MessageResult getMenuList(SystemMenu systemMenu){
        return systemMenuService.getSystemAccount(systemMenu);
    }
    @GetMapping("/menus")
    public MessageResult getListMenu(SystemMenu systemMenu){
        return systemMenuService.getListMenu(systemMenu);
    }

}
