package com.minhphuc.hprserverjava.domain.system;

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
 * @date Wed Sep 06 08:39:03 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("system_api_column")
@RequiredArgsConstructor
public class SystemApiColumn {

    @TableField(value = "column_id")
    @ApiModelProperty(value = "Khoá chính")
    private String columnId;

    @TableField(value = "column_name")
    @ApiModelProperty(value = "Tên cột")
    private String columnName;

    @TableField(value = "column_type")
    @ApiModelProperty(value = "1 int 2 varchar")
    private Integer columnType;

    @TableField(value = "remark")
    @ApiModelProperty(value = "Ghi chú")
    private String remark;

    @TableField(value = "api_fk")
    @ApiModelProperty(value = "Khoá ngoại API")
    private String apiFk;

    @TableField(value = "description")
    @ApiModelProperty(value = "Mô tả")
    private String description;

    @TableField(value = "format")
    @ApiModelProperty(value = "Format")
    private String format;

    @TableField(value = "type")
    @ApiModelProperty(value = "Kiểu dữ liệu")
    private String type;

    @TableField(value = "required")
    @ApiModelProperty(value = "Bắt buộc")
    private Integer required;

 }