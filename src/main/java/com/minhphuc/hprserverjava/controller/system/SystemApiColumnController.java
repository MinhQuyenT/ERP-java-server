package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemApiColumn;
import com.minhphuc.hprserverjava.service.system.SystemApiColumnService;
import com.minhphuc.hprserverjava.util.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 06 08:39:03 GMT+07:00 2023
 */

@Api(tags = "7. API quản lý thông số api")
@RestController
@RequestMapping("/api/v1/systemApiColumn")
@RequiredArgsConstructor
public class SystemApiColumnController {

    private final SystemApiColumnService systemApiColumnService;

    @GetMapping("")
    @ApiOperation("API trả danh sách thông số api")
    private MessageResult getEntity(SystemApiColumn systemApiColumn){
        return systemApiColumnService.getEntity(systemApiColumn);
    }

    @PostMapping("")
    @ApiOperation("API thêm thông số api mới, trả về id")
    private MessageResult insertEntity(@RequestBody SystemApiColumn systemApiColumn){
        return systemApiColumnService.insertEntity(systemApiColumn);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin thông số api")
    private MessageResult updateEntity(@RequestBody SystemApiColumn systemApiColumn){
        return systemApiColumnService.updateEntity(systemApiColumn);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá thông số api, trả về id")
    private MessageResult deleteEntity(String id){
        return systemApiColumnService.deleteEntity(id);
    }

}
