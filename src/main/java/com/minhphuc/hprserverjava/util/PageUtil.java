package com.minhphuc.hprserverjava.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Page")
public class PageUtil {
    public static PageUtil defaut(){
        PageUtil p = new PageUtil();
        p.setPage(1);
        p.setRows(1000);
        return p;
    }

    public  static Page getIpage() {
        Page p = new Page(1,100);
        return p;
    }

    private int start;

    private int rows=20;

    private int page;

    public int getPage() {
        if (start >0) {
            page = start;
        }
        return page;
    }
}
