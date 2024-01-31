package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrShiftDtl;
import com.minhphuc.hprserverjava.service.hr.HrShiftDtlService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:43 GMT+07:00 2023
 */

@Api(tags = "6. API quản lý chi tiết quẹt thẻ")
@RestController
@RequestMapping("/api/v1/hrShiftDtl")
@RequiredArgsConstructor
public class HrShiftDtlController {

    private final HrShiftDtlService hrShiftDtlService;

    @GetMapping("")
    @ApiOperation("API trả danh sách chi tiết quẹt thẻ")
    private MessageResult getEntity(HrShiftDtl hrShiftDtl){
        return hrShiftDtlService.getEntity(hrShiftDtl);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang chi tiết quẹt thẻ")
    private MessageResult getEntityPage(PageUtil pageUtil,HrShiftDtl hrShiftDtl){
        return hrShiftDtlService.getEntityPage(pageUtil,hrShiftDtl);
    }

    @PostMapping("")
    @ApiOperation("API thêm chi tiết quẹt thẻ mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrShiftDtl hrShiftDtl){
        return hrShiftDtlService.insertEntity(hrShiftDtl);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin chi tiết quẹt thẻ")
    private MessageResult updateEntity(@RequestBody HrShiftDtl hrShiftDtl){
        return hrShiftDtlService.updateEntity(hrShiftDtl);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá chi tiết quẹt thẻ, trả về id")
    private MessageResult deleteEntity(String id){
        return hrShiftDtlService.deleteEntity(id);
    }

}
