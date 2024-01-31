package com.minhphuc.hprserverjava.service.system;

import com.minhphuc.hprserverjava.domain.system.SystemApiColumn;
import com.minhphuc.hprserverjava.mapper.system.SystemApiColumnMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 06 08:39:03 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class SystemApiColumnService{

    private final SystemApiColumnMapper systemApiColumnMapper;

    public MessageResult getEntity(SystemApiColumn systemApiColumn){
        return MessageResult.success(systemApiColumnMapper.selectList(ObjectUtil.LikeWrapper(systemApiColumn,null)));
    }
    public MessageResult insertEntity(SystemApiColumn systemApiColumn){
        String id = StringUtil.newID();
        systemApiColumn.setColumnId(id);
        systemApiColumnMapper.insert(systemApiColumn);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(SystemApiColumn systemApiColumn){
        return MessageResult.success(systemApiColumnMapper.updateById(systemApiColumn));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(systemApiColumnMapper.deleteById(id));
    }
}
