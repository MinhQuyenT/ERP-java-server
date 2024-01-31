package com.minhphuc.hprserverjava.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TableName("system_menu")
public class SystemMenu {

    @ApiModelProperty(value = "Mã chính")
    @TableId("menu_id")
    private String menuId;

    @ApiModelProperty(value = "Tên menu")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty(value = "Mô tả menu")
    @TableField("menu_desc")
    private String menuDesc;

    @ApiModelProperty(value = "1 : modules 2: menu 3 button")
    @TableField("menu_type")
    private Integer menuType;

    @ApiModelProperty(value = "Địa chỉ thực theo folder trong project")
    @TableField("path")
    private String path;

    @ApiModelProperty(value = "0: disable 1: enable")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "Theo cấu trúc module:screen:button")
    @TableField("perm")
    private String perm;

    @ApiModelProperty(value = "1: delete default: 0")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "Thời gian tạo")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "Người tạo")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "Thời gian cập nhật")
    @TableField("update_time")
    private String updateTime;

    @ApiModelProperty(value = "Người cập nhật")
    @TableField("updater")
    private String updater;

    @ApiModelProperty(value = "Thời gian xoá")
    @TableField("del_time")
    private String delTime;

    @ApiModelProperty(value = "Người xoá")
    @TableField("del_user")
    private String delUser;

    @ApiModelProperty(value = "ID cha")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "số thứ tự sắp xếp")
    @TableField("sn")
    private Integer sn;

    @ApiModelProperty(value = "icon menu")
    @TableField("icon")
    private String icon;

}
