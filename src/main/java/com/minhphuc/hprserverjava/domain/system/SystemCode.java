package com.minhphuc.hprserverjava.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description="生产进度表 ")
@TableName("GST_POPROCESS")
public class SystemCode {

    @TableId(value = "code_id")
    private String code_id;
    private String code;
    private String code_name;
    private String group;
    private String sn;
    private String lan_vi;
    private String lan_jp;
    private String lan_en;
    private String create_time;

            
    
            
    
            
    
            
    


}
