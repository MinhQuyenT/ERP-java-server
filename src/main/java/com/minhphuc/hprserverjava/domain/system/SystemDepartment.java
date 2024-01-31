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
@ApiModel(description="Bảng phòng ban công ty")
@TableName("system_department")
@RequiredArgsConstructor
public class SystemDepartment {

    @TableId(value = "dp_uuid")
    @ApiModelProperty(value = "Khoá chính")
    private String dpUuid;

    @TableField(value = "dpt_code")
    @ApiModelProperty(value = "Mã phòng ban")
    private String dptCode;

    @TableField(value = "dpt_name_vi")
    @ApiModelProperty(value = "Tên tiếng việt")
    private String dptNameVi;

    @TableField(value = "dpt_name_en")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String dptNameEn;

    @TableField(value = "dpt_name_jp")
    @ApiModelProperty(value = "Tên tiếng nhật")
    private String dptNameJp;

    @TableField(value = "shift_default")
    @ApiModelProperty(value = "Ca làm mặc định")
    private String shiftDefault;

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "Id gốc")
    private String parentId;

    @TableField(value = "sn")
    @ApiModelProperty(value = "sắp xếp")
    private Integer sn;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "Trạng thái xoá")
    private Integer delFlag;

    @TableField(value = "del_time")
    @ApiModelProperty(value = "Thời gian xoá")
    private Date delTime;

    @TableField(value = "del_user")
    @ApiModelProperty(value = "Người xoá")
    private String delUser;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "Thời gian cập nhật")
    private Date updateTime;

    @TableField(value = "updator")
    @ApiModelProperty(value = "Người cập nhật")
    private String updator;

}
