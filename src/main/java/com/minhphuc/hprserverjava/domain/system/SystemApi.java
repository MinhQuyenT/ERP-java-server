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
 * @date Wed Sep 06 08:37:49 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("system_api")
@RequiredArgsConstructor
public class SystemApi {

    @TableField(value = "api_id")
    @ApiModelProperty(value = "Khoá chính")
    private String apiId;

    @TableField(value = "path")
    @ApiModelProperty(value = "Địa chỉ path")
    private String path;

    @TableField(value = "description")
    @ApiModelProperty(value = "Mô tả")
    private String description;

    @TableField(value = "method")
    @ApiModelProperty(value = "1 post 2 put 3 delete 4 get")
    private Integer method;

    @TableField(value = "preview")
    @ApiModelProperty(value = "show content as imgae, file ,...")
    private Integer preview;

    @TableField(value = "auth_required")
    @ApiModelProperty(value = "Có xác thực không? 1: có 0: không")
    private Integer authRequired;

    @TableField(value = "auth_type")
    @ApiModelProperty(value = "Kiểu xác thực")
    private String authType;

    @TableField(value = "spec")
    @ApiModelProperty(value = "Nhóm")
    private String spec;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "Thời gian cập nhật")
    private Date updateTime;

    @TableField(value = "download")
    @ApiModelProperty(value = "chó phép download 1: có 0: không")
    private Integer download;

 }