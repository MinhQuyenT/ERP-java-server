package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrVisa;
import com.minhphuc.hprserverjava.service.hr.HrVisaService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:18:15 GMT+07:00 2023
 */

@Api(tags = "7. API quản lý visa , thị thực")
@RestController
@RequestMapping("/api/v1/hrVisa")
@RequiredArgsConstructor
public class HrVisaController {

    private final HrVisaService hrVisaService;

    @GetMapping("")
    @ApiOperation("API trả danh sách visa , thị thực")
    private MessageResult getEntity(HrVisa hrVisa){
        return hrVisaService.getEntity(hrVisa);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang visa , thị thực")
    private MessageResult getEntityPage(PageUtil pageUtil,HrVisa hrVisa){
        return hrVisaService.getEntityPage(pageUtil,hrVisa);
    }

    @PostMapping("")
    @ApiOperation("API thêm visa , thị thực mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrVisa hrVisa){
        return hrVisaService.insertEntity(hrVisa);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin visa , thị thực")
    private MessageResult updateEntity(@RequestBody HrVisa hrVisa){
        return hrVisaService.updateEntity(hrVisa);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá visa , thị thực, trả về id")
    private MessageResult deleteEntity(String id){
        return hrVisaService.deleteEntity(id);
    }

}
