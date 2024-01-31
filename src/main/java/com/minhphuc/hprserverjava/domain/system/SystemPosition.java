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
@ApiModel(description="Bảng quản lý chức vụ")
@TableName("system_position")
@RequiredArgsConstructor
public class SystemPosition {

    @TableId(value = "pos_id")
    @ApiModelProperty(value = "Khoá chính")
    private String posId;

    @TableField(value = "pos_name_vi")
    @ApiModelProperty(value = "Tên tiếng việt")
    private String posNameVi;

    @TableField(value = "pos_name_en")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String posNameEn;

    @TableField(value = "pos_name_ja")
    @ApiModelProperty(value = "Tên tiếng nhật")
    private String posNameJa;

    @TableField(value = "dpt_fk")
    @ApiModelProperty(value = "khoá phòng ban")
    private String dptFk;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

    @TableField(value = "sn")
    @ApiModelProperty(value = "Sắp xếp")
    private Integer sn;


    @ApiModelProperty(value = "Tìm kiếm theo tên")
    @TableField(exist = false)
    private String posName;



}
