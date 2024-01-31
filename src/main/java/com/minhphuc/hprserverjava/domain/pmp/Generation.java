package com.minhphuc.hprserverjava.domain.pmp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("v_system_table")
public class Generation {

    @TableId(value = "name")
    private String name;

    @TableField(value = "max_length")
    private String maxLength;

    @TableField(value = "column_name")
    private String columnName;

    @TableField(value = "data_type_id")
    private String typeId;

    @TableField(value = "data_type_name")
    private String typeName;

    @TableField(value = "column_comment")
    private String comment;
}
