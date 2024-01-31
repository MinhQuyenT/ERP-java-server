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
 * @date Thu Sep 07 08:17:23 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_shift")
@RequiredArgsConstructor
public class HrShift {

    @TableId(value = "shi_id")
    @ApiModelProperty(value = "Khoá chính")
    private String shiId;

    @TableField(value = "shift_name_vi")
    @ApiModelProperty(value = "Tên ca tiếng việt")
    private String shiftNameVi;

    @TableField(value = "shift_name_en")
    @ApiModelProperty(value = "Tên ca tiếng anh")
    private String shiftNameEn;

    @TableField(value = "shift_name_ja")
    @ApiModelProperty(value = "Tên ca tiếng nhật")
    private String shiftNameJa;

    @TableField(value = "num_hours")
    @ApiModelProperty(value = "Số giờ làm việc")
    private Integer numHours;

    @TableField(value = "remark")
    @ApiModelProperty(value = "Ghi chú")
    private String remark;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "Thời gian update")
    private Date updateTime;

    @TableField(value = "updator")
    @ApiModelProperty(value = "Người cập nhật")
    private String updator;

 }