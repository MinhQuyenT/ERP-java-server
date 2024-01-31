package com.minhphuc.hprserverjava.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@ApiModel(description="Bảng ngôn ngữ hệ thống")
@TableName("system_language")
@RequiredArgsConstructor
public class SystemLanguage {

    @TableId(value = "lan_id")
    @ApiModelProperty(value = "Khoá chính")
    private String lanId;

    @TableField(value = "method")
    @ApiModelProperty(value = "1: Giao diện 2: báo biểu 3: dùng chung")
    private Integer method;

    @TableField(value = "menu_fk")
    @ApiModelProperty(value = "Khoá ngoại giao diện")
    private String menuFk;

    @TableField(value = "report_fk")
    @ApiModelProperty(value = "Khoá ngoại report")
    private String reportFk;

    @TableField(value = "lan_key")
    @ApiModelProperty(value = "Mã ngôn ngữ")
    private String lanKey;

    @TableField(value = "vi")
    @ApiModelProperty(value = "Tiếng Việt")
    private String vi;

    @TableField(value = "en")
    @ApiModelProperty(value = "Tiếng Anh")
    private String en;

    @TableField(value = "jp")
    @ApiModelProperty(value = "Tiếng Nhật")
    private String jp;

    @TableField(value = "allow_edit")
    @ApiModelProperty(value = "1: cho phép 0: không cho phép")
    private Integer allowEdit;

    @TableField(value = "last_update")
    @ApiModelProperty(value = "Thời gian update")
    private Date lastUpdate;

    @TableField(value = "updator")
    @ApiModelProperty(value = "Người cập nhật")
    private String updator;

}
