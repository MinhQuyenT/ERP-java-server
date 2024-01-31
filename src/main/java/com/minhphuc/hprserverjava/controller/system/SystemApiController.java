package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemApi;
import com.minhphuc.hprserverjava.service.system.SystemApiService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 06 08:37:49 GMT+07:00 2023
 */

@Api(tags = "6. API quản lý API")
@RestController
@RequestMapping("/api/v1/systemApi")
@RequiredArgsConstructor
public class SystemApiController {

    private final SystemApiService systemApiService;

    @GetMapping("")
    @ApiOperation("API trả danh sách API")
    private MessageResult getEntity(SystemApi systemApi){
        return systemApiService.getEntity(systemApi);
    }

     @GetMapping("/page")
     @ApiOperation("API trả danh sách API")
     private MessageResult getEntityPage(PageUtil pageUtil,SystemApi systemApi){
         return systemApiService.getEntityPage(pageUtil,systemApi);
     }

    @PostMapping("")
    @ApiOperation("API thêm API mới, trả về id")
    private MessageResult insertEntity(@RequestBody SystemApi systemApi){
        return systemApiService.insertEntity(systemApi);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin API")
    private MessageResult updateEntity(@RequestBody SystemApi systemApi){
        return systemApiService.updateEntity(systemApi);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá API, trả về id")
    private MessageResult deleteEntity(String id){
        return systemApiService.deleteEntity(id);
    }

}
