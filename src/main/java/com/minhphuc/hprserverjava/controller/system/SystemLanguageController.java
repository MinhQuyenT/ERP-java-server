package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.request.LanguageRequest;
import com.minhphuc.hprserverjava.domain.system.SystemLanguage;
import com.minhphuc.hprserverjava.service.system.SystemLanguageService;
import com.minhphuc.hprserverjava.util.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "1. API quản lý đa ngôn ngữ")
@RestController
@RequestMapping("/api/v1/systemLanguage")
@RequiredArgsConstructor

public class SystemLanguageController {

    private final SystemLanguageService systemLanguageService;

    @GetMapping("/use")
    @ApiOperation("API trả json cho web")
    public MessageResult getLanguage(String page,String lan){
        return systemLanguageService.getLanguage(lan,page);
    }

    @GetMapping()
    @ApiOperation("API tra cứu danh sách ngôn ngữ")
    public MessageResult getListLanguage(SystemLanguage systemLanguage){
        return systemLanguageService.getListSystem(systemLanguage);
    }

    @PostMapping()
    @ApiOperation("API thêm một ngôn ngữ mới")
    public MessageResult insertLanguage(@RequestBody SystemLanguage systemLanguage){
        return systemLanguageService.insertLanguage(systemLanguage);
    }

    @PutMapping()
    @ApiOperation("API cập nhật ngôn ngữ")
    public MessageResult updateLanguage(@RequestBody SystemLanguage systemLanguage){
        return systemLanguageService.updateLanguage(systemLanguage);
    }

    @DeleteMapping()
    @ApiOperation("API xoá ngôn ngữ")
    public MessageResult deleteLanguage( String id){
        return systemLanguageService.deleteLanguage(id);
    }

    @PostMapping("/all")
    @ApiOperation("API cập nhật ngôn ngữ cả trang")
    public MessageResult updateLanguages(@RequestBody LanguageRequest languageList){
        return systemLanguageService.updateLanguages(languageList);
    }
}
