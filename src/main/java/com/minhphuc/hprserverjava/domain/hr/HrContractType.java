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
 * @date Thu Sep 07 08:17:00 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_contract_type")
@RequiredArgsConstructor
public class HrContractType {

    @TableId(value = "con_type_id")
    @ApiModelProperty(value = "Khoá chính")
    private String conTypeId;

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