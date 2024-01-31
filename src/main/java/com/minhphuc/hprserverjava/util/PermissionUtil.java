package com.minhphuc.hprserverjava.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.minhphuc.hprserverjava.domain.view.ViewSystemPermisson;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class PermissionUtil {

    public static void getPermission(QueryWrapper wrapper, List<ViewSystemPermisson> list) {
        for (ViewSystemPermisson item:list) {
            if(StringUtils.isNotBlank(item.getColumnName())){
                wrapper.eq(item.getColumnName(),item.getValue());
            }
        }
    }

    public static Boolean checkPermission(List<ViewSystemPermisson> list) {
        if(list.size()==0){
            return false;
        }
        for (ViewSystemPermisson item:list) {
            if (item.getPermType()==1){
                return false;
            }
        }
        return true;
    }
}
