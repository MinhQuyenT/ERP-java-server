package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrShift;
import com.minhphuc.hprserverjava.service.hr.HrShiftService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:23 GMT+07:00 2023
 */

@Api(tags = "5. API quản lý ca làm việc")
@RestController
@RequestMapping("/api/v1/hrShift")
@RequiredArgsConstructor
public class HrShiftController {

    private final HrShiftService hrShiftService;

    @GetMapping("")
    @ApiOperation("API trả danh sách ca làm việc")
    private MessageResult getEntity(HrShift hrShift){
        return hrShiftService.getEntity(hrShift);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang ca làm việc")
    private MessageResult getEntityPage(PageUtil pageUtil,HrShift hrShift){
        return hrShiftService.getEntityPage(pageUtil,hrShift);
    }

    @PostMapping("")
    @ApiOperation("API thêm ca làm việc mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrShift hrShift){
        return hrShiftService.insertEntity(hrShift);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin ca làm việc")
    private MessageResult updateEntity(@RequestBody HrShift hrShift){
        return hrShiftService.updateEntity(hrShift);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá ca làm việc, trả về id")
    private MessageResult deleteEntity(String id){
        return hrShiftService.deleteEntity(id);
    }

}
