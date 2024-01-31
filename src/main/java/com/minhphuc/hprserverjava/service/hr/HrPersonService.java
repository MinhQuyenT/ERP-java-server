package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrPerson;
import com.minhphuc.hprserverjava.mapper.hr.HrPersonMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:05:05 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrPersonService{

    private final HrPersonMapper hrPersonMapper;

    public MessageResult getEntity(HrPerson hrPerson){
        return MessageResult.success(hrPersonMapper.selectList(ObjectUtil.LikeWrapper(hrPerson,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrPerson hrPerson){
         return MessageResult.success(hrPersonMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrPerson,null)));
    }

    public MessageResult insertEntity(HrPerson hrPerson){
        String id = StringUtil.newID();
        hrPerson.setPerId(id);
        hrPersonMapper.insert(hrPerson);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrPerson hrPerson){
        return MessageResult.success(hrPersonMapper.updateById(hrPerson));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrPersonMapper.deleteById(id));
    }
}
