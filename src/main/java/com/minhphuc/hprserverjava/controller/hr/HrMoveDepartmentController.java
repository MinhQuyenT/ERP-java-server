package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrMoveDepartment;
import com.minhphuc.hprserverjava.service.hr.HrMoveDepartmentService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:14:26 GMT+07:00 2023
 */

@Api(tags = "2. API quản lý chuyển phòng ban")
@RestController
@RequestMapping("/api/v1/hrMoveDepartment")
@RequiredArgsConstructor
public class HrMoveDepartmentController {

    private final HrMoveDepartmentService hrMoveDepartmentService;

    @GetMapping("")
    @ApiOperation("API trả danh sách chuyển phòng ban")
    private MessageResult getEntity(HrMoveDepartment hrMoveDepartment){
        return hrMoveDepartmentService.getEntity(hrMoveDepartment);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang chuyển phòng ban")
    private MessageResult getEntityPage(PageUtil pageUtil,HrMoveDepartment hrMoveDepartment){
        return hrMoveDepartmentService.getEntityPage(pageUtil,hrMoveDepartment);
    }

    @PostMapping("")
    @ApiOperation("API thêm chuyển phòng ban mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrMoveDepartment hrMoveDepartment){
        return hrMoveDepartmentService.insertEntity(hrMoveDepartment);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin chuyển phòng ban")
    private MessageResult updateEntity(@RequestBody HrMoveDepartment hrMoveDepartment){
        return hrMoveDepartmentService.updateEntity(hrMoveDepartment);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá chuyển phòng ban, trả về id")
    private MessageResult deleteEntity(String id){
        return hrMoveDepartmentService.deleteEntity(id);
    }

}
