package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrContractType;
import com.minhphuc.hprserverjava.mapper.hr.HrContractTypeMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:00 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrContractTypeService{

    private final HrContractTypeMapper hrContractTypeMapper;

    public MessageResult getEntity(HrContractType hrContractType){
        return MessageResult.success(hrContractTypeMapper.selectList(ObjectUtil.LikeWrapper(hrContractType,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrContractType hrContractType){
         return MessageResult.success(hrContractTypeMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrContractType,null)));
    }
        public MessageResult insertEntity(HrContractType hrContractType){
        String id = StringUtil.newID();
        hrContractType.setConTypeId(id);
        hrContractTypeMapper.insert(hrContractType);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrContractType hrContractType){
        return MessageResult.success(hrContractTypeMapper.updateById(hrContractType));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrContractTypeMapper.deleteById(id));
    }
}
