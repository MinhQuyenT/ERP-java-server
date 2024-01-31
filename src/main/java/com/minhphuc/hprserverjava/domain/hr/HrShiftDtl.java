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
 * @date Thu Sep 07 08:17:43 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_shift_dtl")
@RequiredArgsConstructor
public class HrShiftDtl {

    @TableId(value = "shi_dtl_id")
    @ApiModelProperty(value = "Khoá chính")
    private String shiDtlId;

    @TableField(value = "shi_fk")
    @ApiModelProperty(value = "Khoá ca làm")
    private String shiFk;

    @TableField(value = "start_time")
    @ApiModelProperty(value = "Thời gian bắt đầu")
    private String startTime;

    @TableField(value = "end_time")
    @ApiModelProperty(value = "Thời gian kết thúc")
    private String endTime;

    @TableField(value = "over_night")
    @ApiModelProperty(value = "ca đêm")
    private Integer overNight;

    @TableField(value = "early_min")
    @ApiModelProperty(value = "Số phút đi sớm")
    private Integer earlyMin;

    @TableField(value = "late_min")
    @ApiModelProperty(value = "Số phút đi trễ")
    private Integer lateMin;

    @TableField(value = "enable")
    @ApiModelProperty(value = "trạng thái")
    private Integer enable;

 }