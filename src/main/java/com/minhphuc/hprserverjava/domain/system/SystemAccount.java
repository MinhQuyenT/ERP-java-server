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
@TableName("system_account")
@RequiredArgsConstructor
public class SystemAccount {

    @TableId(value = "account_id")
    @ApiModelProperty(value = "Khoá chính")
    private String accountId;

    @TableField(value = "username")
    @ApiModelProperty(value = "Tài khoản đăng nhập")
    private String username;

    @TableField(value = "password")
    @ApiModelProperty(value = "Mật khẩu")
    private String password;

    @TableField(value = "fullname")
    @ApiModelProperty(value = "Họ và tên")
    private String fullname;

    @TableField(value = "nickname")
    @ApiModelProperty(value = "Tên hiển thị ở web")
    private String nickname;

    @TableField(value = "status")
    @ApiModelProperty(value = "Trạng thái")
    private Integer status;

    @TableField(value = "staff_fk")
    @ApiModelProperty(value = "Mã khoá nhân viên")
    private String staffFk;

    @TableField(value = "ip_address")
    @ApiModelProperty(value = "Địa chỉ IP")
    private String ipAddress;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "0: chưa xoá 1: đã xoá")
    private Integer delFlag;

    @TableField(value = "del_time")
    @ApiModelProperty(value = "Thời gian xoá")
    private Date delTime;

    @TableField(value = "del_user")
    @ApiModelProperty(value = "Người xoá")
    private String delUser;



}
