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
 * @date Thu Sep 07 08:15:23 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_contract")
@RequiredArgsConstructor
public class HrContract {

    @TableId(value = "con_id")
    @ApiModelProperty(value = "Khoá chính")
    private String conId;

    @TableField(value = "per_fk")
    @ApiModelProperty(value = "khoá nhân viên")
    private String perFk;

    @TableField(value = "con_type_fk")
    @ApiModelProperty(value = "loại hợp đồng")
    private String conTypeFk;

    @TableField(value = "start_date")
    @ApiModelProperty(value = "Ngày bắt đầu")
    private Date startDate;

    @TableField(value = "end_date")
    @ApiModelProperty(value = "Ngày kết thúc")
    private Date endDate;

    @TableField(value = "salary")
    @ApiModelProperty(value = "Mức lương")
    private String salary;

    @TableField(value = "is_print")
    @ApiModelProperty(value = "Đã in")
    private Integer isPrint;

    @TableField(value = "print_date")
    @ApiModelProperty(value = "Thời gian in")
    private Date printDate;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "Thời gian cập nhật")
    private Date updateTime;

    @TableField(value = "updator")
    @ApiModelProperty(value = "Người cập nhật")
    private String updator;

 }