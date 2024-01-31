package com.minhphuc.hprserverjava.domain.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.minhphuc.hprserverjava.domain.hr.HrContract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * Write code by Minh Phúc
 * @author Minh Phúc
 * @date Mon Sep 18 09:21:23 GMT+07:00 2023
 */

@Data
@ApiModel(description="")
@TableName("v_hr_contract")
@RequiredArgsConstructor
public class ViewHrContract extends HrContract {

    @TableField(value = "per_code")
    @ApiModelProperty(value = "Mã nhân viên")
    private String perCode;

    @TableField(value = "per_name_vi")
    @ApiModelProperty(value = "Tên tiếng việt")
    private String perNameVi;

    @TableField(value = "per_name_ja")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String perNameJa;

    @TableField(value = "per_name_en")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String perNameEn;

    @TableField(value = "birthday")
    @ApiModelProperty(value = "Ngày sinh")
    private Date birthday;

    @TableField(value = "position_fk")
    @ApiModelProperty(value = "khoá vị trí")
    private String positionFk;

    @TableField(value = "type_name_vi")
    @ApiModelProperty(value = "Tên tiếng việt")
    private String typeNameVi;

    @TableField(value = "type_name_en")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String typeNameEn;

    @TableField(value = "type_name_ja")
    @ApiModelProperty(value = "Tên tiếng nhật")
    private String typeNameJa;

    @TableField(value = "num_month")
    @ApiModelProperty(value = "Số tháng")
    private Integer numMonth;

    @TableField(value = "part_time")
    @ApiModelProperty(value = "Thời vụ")
    private Integer partTime;

    @TableField(value = "remake")
    @ApiModelProperty(value = "Ghi chú")
    private String remake;
}
