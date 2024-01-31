package com.minhphuc.hprserverjava.controller.hr;

import com.minhphuc.hprserverjava.domain.hr.HrFurlough;
import com.minhphuc.hprserverjava.service.hr.HrFurloughService;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 13 13:06:02 GMT+07:00 2023
 */

@Api(tags = "8. API quản lý nghỉ phép")
@RestController
@RequestMapping("/api/v1/hrFurlough")
@RequiredArgsConstructor
public class HrFurloughController {

    private final HrFurloughService hrFurloughService;

    @GetMapping("")
    @ApiOperation("API trả danh sách nghỉ phép")
    private MessageResult getEntity(HrFurlough hrFurlough){
        return hrFurloughService.getEntity(hrFurlough);
    }

    @GetMapping("/page")    @ApiOperation("API trả danh sách theo trang nghỉ phép")
    private MessageResult getEntityPage(PageUtil pageUtil,HrFurlough hrFurlough){
        return hrFurloughService.getEntityPage(pageUtil,hrFurlough);
    }

    @PostMapping("")
    @ApiOperation("API thêm nghỉ phép mới, trả về id")
    private MessageResult insertEntity(@RequestBody HrFurlough hrFurlough){
        return hrFurloughService.insertEntity(hrFurlough);
    }

    @PutMapping("")
    @ApiOperation("API cập nhật thông tin nghỉ phép")
    private MessageResult updateEntity(@RequestBody HrFurlough hrFurlough){
        return hrFurloughService.updateEntity(hrFurlough);
    }

    @DeleteMapping("")
    @ApiOperation("API xoá nghỉ phép, trả về id")
    private MessageResult deleteEntity(String id){
        return hrFurloughService.deleteEntity(id);
    }

}
