package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrPerson;
import com.minhphuc.hprserverjava.service.hr.HrPersonService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:05:05 GMT+07:00 2023
 */

@Api(tags = "1. API quản lý nhân sự")
@RestController
@RequestMapping("/api/v1/hrPerson")
@RequiredArgsConstructor
public class HrPersonController {

    private final HrPersonService hrPersonService;

    @GetMapping("")
    @ApiOperation("API trả danh sách nhân sự")
    private MessageResult getEntity(HrPerson hrPerson){
        return hrPersonService.getEntity(hrPerson);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang nhân sự")
    private MessageResult getEntityPage(PageUtil pageUtil,HrPerson hrPerson){
        return hrPersonService.getEntityPage(pageUtil,hrPerson);
    }

    @PostMapping("")
    @ApiOperation("API thêm nhân sự mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrPerson hrPerson){
        return hrPersonService.insertEntity(hrPerson);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin nhân sự")
    private MessageResult updateEntity(@RequestBody HrPerson hrPerson){
        return hrPersonService.updateEntity(hrPerson);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá nhân sự, trả về id")
    private MessageResult deleteEntity(String id){
        return hrPersonService.deleteEntity(id);
    }

}
