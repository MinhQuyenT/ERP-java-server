package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemAccount;
import com.minhphuc.hprserverjava.service.system.SystemAccountService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "3. API quản lý tài khoản đăng nhập")
@RestController
@RequestMapping("/api/v1/systemAccount")
@RequiredArgsConstructor
public class SystemAccountController {

    private final SystemAccountService systemAccountService;

    @GetMapping("/page")
    @ApiOperation("API trả danh sách nhân viên theo trang")
    public MessageResult getAccountsByPage(SystemAccount systemAccount, PageUtil page){
        return systemAccountService.getAccountListbyPage(systemAccount,page);
    }

    @GetMapping()
    @ApiOperation("APItrả danh sách nhân viên")
    public MessageResult getAccountList(SystemAccount systemAccount){
        return systemAccountService.getAccountList(systemAccount);
    }

    @PostMapping()
    @ApiOperation("API cập nhật thông tin đăng nhập")
    public MessageResult insertAccount(@RequestBody SystemAccount systemAccount){
        return systemAccountService.insertAccount(systemAccount);
    }

    @PutMapping()
    @ApiOperation("API cập nhật tài khoản")
    public MessageResult updateAccount(@RequestBody SystemAccount systemAccount){
        return systemAccountService.updateAccount(systemAccount);
    }

    @DeleteMapping()
    @ApiOperation("API xoá tài khoản dựa vào id")
    public MessageResult updateAccount(String id){
        return systemAccountService.deleteAccount(id);
    }
}
