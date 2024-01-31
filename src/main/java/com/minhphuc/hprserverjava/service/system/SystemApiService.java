package com.minhphuc.hprserverjava.service.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.system.SystemApi;
import com.minhphuc.hprserverjava.mapper.system.SystemApiMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 06 08:37:49 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class SystemApiService{

    private final SystemApiMapper systemApiMapper;

    public MessageResult getEntity(SystemApi systemApi){
        return MessageResult.success(systemApiMapper.selectList(ObjectUtil.LikeWrapper(systemApi,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,SystemApi systemApi){
         return MessageResult.success(systemApiMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(systemApi,null)));
    }
    
    public MessageResult insertEntity(SystemApi systemApi){
        String id = StringUtil.newID();
        systemApi.setApiId(id);
        systemApiMapper.insert(systemApi);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(SystemApi systemApi){
        systemApi.setUpdateTime(new Date());
        return MessageResult.success(systemApiMapper.updateById(systemApi));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(systemApiMapper.deleteById(id));
    }
}
