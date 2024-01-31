package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrContract;
import com.minhphuc.hprserverjava.service.hr.HrContractService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:15:23 GMT+07:00 2023
 */

@Api(tags = "3. API quản lý hợp đồng")
@RestController
@RequestMapping("/api/v1/hrContract")
@RequiredArgsConstructor
public class HrContractController {

    private final HrContractService hrContractService;

    @GetMapping("")
    @ApiOperation("API trả danh sách hợp đồng")
    private MessageResult getEntity(HrContract hrContract){
        return hrContractService.getEntity(hrContract);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang hợp đồng")
    private MessageResult getEntityPage(PageUtil pageUtil,HrContract hrContract){
        return hrContractService.getEntityPage(pageUtil,hrContract);
    }

    @PostMapping("")
    @ApiOperation("API thêm hợp đồng mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrContract hrContract){
        return hrContractService.insertEntity(hrContract);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin hợp đồng")
    private MessageResult updateEntity(@RequestBody HrContract hrContract){
        return hrContractService.updateEntity(hrContract);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá hợp đồng, trả về id")
    private MessageResult deleteEntity(String id){
        return hrContractService.deleteEntity(id);
    }

}
