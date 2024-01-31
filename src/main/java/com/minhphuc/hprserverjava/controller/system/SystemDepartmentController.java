package com.minhphuc.hprserverjava.controller.system;

import com.minhphuc.hprserverjava.domain.system.SystemDepartment;
import com.minhphuc.hprserverjava.service.system.SystemDepartmentService;
import com.minhphuc.hprserverjava.util.MessageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "4. API quản lý phòng ban")
@RestController
@RequestMapping("/api/v1/systemDepartment")
@RequiredArgsConstructor
public class SystemDepartmentController {

    private final SystemDepartmentService systemDepartmentService;

    @GetMapping("")
    @ApiOperation("API trả danh sách phòng ban")
    private MessageResult getEntity(SystemDepartment systemDepartment){
        return systemDepartmentService.getEntity(systemDepartment);
    }

    @PostMapping("")
    @ApiOperation("API thêm phòng ban mới, trả về id")
    private MessageResult insertEntity(@RequestBody SystemDepartment systemDepartment){
        return systemDepartmentService.insertEntity(systemDepartment);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin phòng ban")
    private MessageResult updateEntity(@RequestBody SystemDepartment systemDepartment){
        return systemDepartmentService.updateEntity(systemDepartment);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá phòng ban, trả về id")
    private MessageResult deleteEntity(String id){
        return systemDepartmentService.deleteEntity(id);
    }

    @GetMapping("/tree")
    @ApiOperation("API trả về cây thự mục { title , key , children }")
    private MessageResult jsonEntity(SystemDepartment systemDepartment,String lan){
        return systemDepartmentService.treeJson(systemDepartment,lan);
    }

}
