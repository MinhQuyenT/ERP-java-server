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
 * @date Thu Sep 07 08:05:05 GMT+07:00 2023
 */
@Data
@ApiModel(description="")
@TableName("hr_person")
@RequiredArgsConstructor
public class HrPerson {

    @TableId(value = "per_id")
    @ApiModelProperty(value = "Khoá chính")
    private String perId;

    @TableField(value = "per_code")
    @ApiModelProperty(value = "Mã nhân viên")
    private String perCode;

    @TableField(value = "per_name_vi")
    @ApiModelProperty(value = "Tên tiếng việt")
    private String perNameVi;

    @TableField(value = "per_name_ja")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String perNameJa;

    @TableField(value = "per_name_en")
    @ApiModelProperty(value = "Tên tiếng anh")
    private String perNameEn;

    @TableField(value = "birthday")
    @ApiModelProperty(value = "Ngày sinh")
    private Date birthday;

    @TableField(value = "gender")
    @ApiModelProperty(value = "giới tính")
    private Integer gender;

    @TableField(value = "phone")
    @ApiModelProperty(value = "số điện thoại")
    private String phone;

    @TableField(value = "mail")
    @ApiModelProperty(value = "mail")
    private String mail;

    @TableField(value = "blood_group")
    @ApiModelProperty(value = "Nhóm máu")
    private String bloodGroup;


    @TableField(value = "address1")
    @ApiModelProperty(value = "Địa chị thường trú")
    private String address1;

    @TableField(value = "address2")
    @ApiModelProperty(value = "Địa chỉ tạm trú")
    private String address2;

    @TableField(value = "bank_no")
    @ApiModelProperty(value = "Số tài khoản ngân hàng")
    private String bankNo;

    @TableField(value = "bank_name")
    @ApiModelProperty(value = "Tên ngân hàng")
    private String bankName;

    @TableField(value = "mate")
    @ApiModelProperty(value = "vợ/Chồng")
    private String mate;

    @TableField(value = "mate_birth")
    @ApiModelProperty(value = "Ngày sinh")
    private Date mateBirth;

    @TableField(value = "mate_phone")
    @ApiModelProperty(value = "Số điện thoại")
    private String matePhone;

    @TableField(value = "mate_job")
    @ApiModelProperty(value = "Nghề nghiệp")
    private String mateJob;

     @TableField(value = "get_marry")
     @ApiModelProperty(value = "Tình trạng hôn nhân")
     private Integer getMarry;

    @TableField(value = "children_name1")
    @ApiModelProperty(value = "Tên con")
    private String childrenName1;

    @TableField(value = "children_birth1")
    @ApiModelProperty(value = "Ngày sinh của con")
    private Date childrenBirth1;

    @TableField(value = "children_name2")
    @ApiModelProperty(value = "Tên con")
    private String childrenName2;

    @TableField(value = "children_birth2")
    @ApiModelProperty(value = "Ngày sinh của con")
    private Date childrenBirth2;

    @TableField(value = "children_name3")
    @ApiModelProperty(value = "Tên con")
    private String childrenName3;

    @TableField(value = "children_birth3")
    @ApiModelProperty(value = "Ngày sinh của con")
    private Date childrenBirth3;

    @TableField(value = "children_name4")
    @ApiModelProperty(value = "Tên con")
    private String childrenName4;

    @TableField(value = "children_birth4")
    @ApiModelProperty(value = "Ngày sinh của con")
    private Date childrenBirth4;

    @TableField(value = "children_name5")
    @ApiModelProperty(value = "Tên con")
    private String childrenName5;

    @TableField(value = "children_birth5")
    @ApiModelProperty(value = "Ngày sinh của con")
    private Date childrenBirth5;

    @TableField(value = "mon_name")
    @ApiModelProperty(value = "Tên mẹ")
    private String monName;

    @TableField(value = "mon_birth")
    @ApiModelProperty(value = "Ngày sinh")
    private Date monBirth;

    @TableField(value = "dad_name")
    @ApiModelProperty(value = "Tên ba")
    private String dadName;

    @TableField(value = "dad_birth")
    @ApiModelProperty(value = "Ngày sinh")
    private Date dadBirth;

    @TableField(value = "mon_phone")
    @ApiModelProperty(value = "Số điện thoại me")
    private String monPhone;

    @TableField(value = "dad_phone")
    @ApiModelProperty(value = "Số điện thoại của ba")
    private String dadPhone;

    @TableField(value = "md_address")
    @ApiModelProperty(value = "Địa chỉ phụ huynh")
    private String mdAddress;

    @TableField(value = "vehicle")
    @ApiModelProperty(value = "Phương tiện đi lại")
    private String vehicle;

    @TableField(value = "shirt_size")
    @ApiModelProperty(value = "Size áo")
    private String shirtSize;

    @TableField(value = "diseases")
    @ApiModelProperty(value = "Các loại bệnh ( nếu có)")
    private String diseases;

    @TableField(value = "position_fk")
    @ApiModelProperty(value = "khoá vị trí")
    private String positionFk;

    @TableField(value = "contract_fk")
    @ApiModelProperty(value = "khoá hợp đồng")
    private String contractFk;

    @TableField(value = "job_date")
    @ApiModelProperty(value = "Ngày nhận việc")
    private Date jobDate;

    @TableField(value = "interview_date")
    @ApiModelProperty(value = "Ngày phỏng vấn")
    private Date interviewDate;

    @TableField(value = "level")
    @ApiModelProperty(value = "Trình độ")
    private Integer level;

    @TableField(value = "graduation_shool")
    @ApiModelProperty(value = "Trường tốt nghiệp")
    private String graduationShool;

    @TableField(value = "card_old")
    @ApiModelProperty(value = "CMND cũ")
    private String cardOld;

    @TableField(value = "card_new")
    @ApiModelProperty(value = "CMND Mới")
    private String cardNew;

    @TableField(value = "card_date")
    @ApiModelProperty(value = "ngày cấp")
    private Date cardDate;

    @TableField(value = "card_issued")
    @ApiModelProperty(value = "Nơi cấp")
    private String cardIssued;

    @TableField(value = "remark")
    @ApiModelProperty(value = "ghi chú")
    private String remark;

    @TableField(value = "status")
    @ApiModelProperty(value = "trạng thái 1: đang làm 2: đã nghỉ 3: tạm nghĩ")
    private Integer status;

    @TableField(value = "avatar")
    @ApiModelProperty(value = "Hình đại diện")
    private String avatar;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "Thời gian tạo")
    private Date createTime;

    @TableField(value = "creator")
    @ApiModelProperty(value = "Người tạo")
    private String creator;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "Trạng thái xoá")
    private Integer delFlag;

    @TableField(value = "del_user")
    @ApiModelProperty(value = "Người xoá")
    private String delUser;

    @TableField(value = "del_time")
    @ApiModelProperty(value = "Thời gian xoá")
    private Date delTime;

 }