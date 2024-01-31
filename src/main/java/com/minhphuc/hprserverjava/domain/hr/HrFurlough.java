package com.minhphuc.hprserverjava.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 13 13:06:02 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_furlough")
@RequiredArgsConstructor
public class HrFurlough {

    @TableId(value = "fur_id")
    @ApiModelProperty(value = "khoá chính")
    private String furId;

    @TableField(value = "fur_type_fk")
    @ApiModelProperty(value = "khoá mã loại phép")
    private String furTypeFk;

    @TableField(value = "from_date")
    @ApiModelProperty(value = "từ ngày")
    private Date fromDate;

    @TableField(value = "to_date")
    @ApiModelProperty(value = "Đến ngày")
    private Date toDate;

    @TableField(value = "among")
    @ApiModelProperty(value = "Số tiếng")
    private Integer among;

    @TableField(value = "reason")
    @ApiModelProperty(value = "lý do")
    private String reason;

    @TableField(value = "fur_resg_time")
    @ApiModelProperty(value = "Ngày đăng ký")
    private Date furResgTime;

    @TableField(value = "remark")
    @ApiModelProperty(value = "Ghi chú")
    private String remark;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "Trạng thái xoá")
    private Integer delFlag;

    @TableField(value = "del_time")
    @ApiModelProperty(value = "Thời gian xoá")
    private Date delTime;

 }