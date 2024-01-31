package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemPosition;
import com.minhphuc.hprserverjava.service.system.SystemPositionService;
import com.minhphuc.hprserverjava.util.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "5. API quản lý chức vụ")
@RestController
@RequestMapping("/api/v1/systemPosition")
@RequiredArgsConstructor
public class SystemPositionController {

    private final SystemPositionService systemPositionService;

    @GetMapping("")
    @ApiOperation("API trả danh sách chức vụ")
    private MessageResult getEntity(SystemPosition systemPosition){
        return systemPositionService.getEntity(systemPosition);
    }

    @PostMapping("")
    @ApiOperation("API thêm chức vụ mới, trả về id")
    private MessageResult insertEntity(@RequestBody SystemPosition systemPosition){
        return systemPositionService.insertEntity(systemPosition);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin chức vụ")
    private MessageResult updateEntity(@RequestBody SystemPosition systemPosition){
        return systemPositionService.updateEntity(systemPosition);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá chức vụ, trả về id")
    private MessageResult deleteEntity(String id){
        return systemPositionService.deleteEntity(id);
    }

}
