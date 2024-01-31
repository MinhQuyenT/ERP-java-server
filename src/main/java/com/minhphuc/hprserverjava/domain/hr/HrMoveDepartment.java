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
 * @date Thu Sep 07 08:14:26 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_move_department")
@RequiredArgsConstructor
public class HrMoveDepartment {

    @TableId(value = "mov_id")
    @ApiModelProperty(value = "Khoá chính")
    private String movId;

    @TableField(value = "per_fk")
    @ApiModelProperty(value = "Khoá nhân viên")
    private String perFk;

    @TableField(value = "dpt_fk")
    @ApiModelProperty(value = "Khoá phòng ban")
    private String dptFk;

    @TableField(value = "pos_fk")
    @ApiModelProperty(value = "Khoá vị trí")
    private String posFk;

    @TableField(value = "move_time")
    @ApiModelProperty(value = "Thời gian chuyển")
    private Date moveTime;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

 }