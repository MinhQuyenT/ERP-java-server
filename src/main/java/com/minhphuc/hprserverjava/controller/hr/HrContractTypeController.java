package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrContractType;
import com.minhphuc.hprserverjava.service.hr.HrContractTypeService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:00 GMT+07:00 2023
 */

@Api(tags = "4. API quản lý kiểu hợp đồng")
@RestController
@RequestMapping("/api/v1/hrContractType")
@RequiredArgsConstructor
public class HrContractTypeController {

    private final HrContractTypeService hrContractTypeService;

    @GetMapping("")
    @ApiOperation("API trả danh sách kiểu hợp đồng")
    private MessageResult getEntity(HrContractType hrContractType){
        return hrContractTypeService.getEntity(hrContractType);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang kiểu hợp đồng")
    private MessageResult getEntityPage(PageUtil pageUtil,HrContractType hrContractType){
        return hrContractTypeService.getEntityPage(pageUtil,hrContractType);
    }

    @PostMapping("")
    @ApiOperation("API thêm kiểu hợp đồng mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrContractType hrContractType){
        return hrContractTypeService.insertEntity(hrContractType);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin kiểu hợp đồng")
    private MessageResult updateEntity(@RequestBody HrContractType hrContractType){
        return hrContractTypeService.updateEntity(hrContractType);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá kiểu hợp đồng, trả về id")
    private MessageResult deleteEntity(String id){
        return hrContractTypeService.deleteEntity(id);
    }

}
