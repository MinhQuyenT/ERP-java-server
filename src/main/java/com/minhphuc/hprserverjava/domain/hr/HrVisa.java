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
 * @date Thu Sep 07 08:18:15 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_visa")
@RequiredArgsConstructor
public class HrVisa {

    @TableId(value = "vis_id")
    @ApiModelProperty(value = "Khoá ngoại")
    private String visId;

    @TableField(value = "per_fk")
    @ApiModelProperty(value = "Khoá nhân viên")
    private String perFk;

    @TableField(value = "type")
    @ApiModelProperty(value = "Thể loại, visa, passport,...")
    private String type;

    @TableField(value = "issua_date")
    @ApiModelProperty(value = "Ngày cấp")
    private Date issuaDate;

    @TableField(value = "issua_place")
    @ApiModelProperty(value = "Nơi cấp")
    private String issuaPlace;

    @TableField(value = "exp_date")
    @ApiModelProperty(value = "Ngày hết hạn")
    private Date expDate;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

 }