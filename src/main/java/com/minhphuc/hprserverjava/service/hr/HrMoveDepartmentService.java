package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrMoveDepartment;
import com.minhphuc.hprserverjava.mapper.hr.HrMoveDepartmentMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:14:26 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrMoveDepartmentService{

    private final HrMoveDepartmentMapper hrMoveDepartmentMapper;

    public MessageResult getEntity(HrMoveDepartment hrMoveDepartment){
        return MessageResult.success(hrMoveDepartmentMapper.selectList(ObjectUtil.LikeWrapper(hrMoveDepartment,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrMoveDepartment hrMoveDepartment){
         return MessageResult.success(hrMoveDepartmentMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrMoveDepartment,null)));
    }
        public MessageResult insertEntity(HrMoveDepartment hrMoveDepartment){
        String id = StringUtil.newID();
        hrMoveDepartment.setMovId(id);
        hrMoveDepartmentMapper.insert(hrMoveDepartment);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrMoveDepartment hrMoveDepartment){
        return MessageResult.success(hrMoveDepartmentMapper.updateById(hrMoveDepartment));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrMoveDepartmentMapper.deleteById(id));
    }
}
