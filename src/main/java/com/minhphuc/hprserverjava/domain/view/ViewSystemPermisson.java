package com.minhphuc.hprserverjava.domain.view;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@TableName("v_system_permission")
public class ViewSystemPermisson{

    @TableId(value = "id")
    @ApiModelProperty(value = "Primary key")
    private String id;

    @TableField(value = "path")
    @ApiModelProperty(value = "Endpoint URL")
    private String path;

    @TableField(value = "method")
    @ApiModelProperty(value = "Request Method")
    private String method;

    @TableField(value = "perm_type")
    @ApiModelProperty(value = "1 deny 2 allow")
    private Integer permType;

    @TableField(value = "column_name")
    @ApiModelProperty(value = "Column Name")
    private String columnName;

    @TableField(value = "column_type")
    @ApiModelProperty(value = "Column Type")
    private String columnType;

    @TableField(value = "value")
    @ApiModelProperty(value = "Value")
    private String value;
}
