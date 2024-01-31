package com.minhphuc.hprserverjava.service.system;

import com.minhphuc.hprserverjava.domain.response.TreeRespone;
import com.minhphuc.hprserverjava.domain.system.SystemDepartment;
import com.minhphuc.hprserverjava.mapper.system.SystemDepartmentMapper;
import com.minhphuc.hprserverjava.util.DepartmentUtil;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemDepartmentService {

    private final SystemDepartmentMapper systemDepartmentMapper;

    public MessageResult getEntity(SystemDepartment systemDepartment){
        return MessageResult.success(systemDepartmentMapper.selectList(ObjectUtil.LikeWrapper(systemDepartment,null)));
    }

    public MessageResult insertEntity(SystemDepartment systemDepartment){
        String uuid = StringUtil.newID();
        systemDepartment.setDpUuid(uuid);
        systemDepartment.setUpdateTime(new Date());
        systemDepartmentMapper.insert(systemDepartment);
        return MessageResult.success(uuid);
    }

    public MessageResult updateEntity(SystemDepartment systemDepartment){
        if(systemDepartment.getDpUuid()==null){
            return MessageResult.error("dont found language id");
        }
        systemDepartment.setUpdateTime(new Date());
        systemDepartmentMapper.updateById(systemDepartment);
        return MessageResult.success(systemDepartment.getDpUuid());
    }

    public MessageResult deleteEntity(String id){
        if(id==null){
            return MessageResult.error("dont found language id");
        }
        systemDepartmentMapper.deleteById(id);
        return MessageResult.success(id);
    }

    public MessageResult treeJson(SystemDepartment systemDepartment,String lan){
        List<SystemDepartment> departmentList = systemDepartmentMapper.selectList(ObjectUtil.LikeWrapper(systemDepartment,null));
        return MessageResult.success(DepartmentUtil.convertTree(departmentList,lan));
    }

}
