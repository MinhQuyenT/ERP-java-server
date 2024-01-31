package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrVisa;
import com.minhphuc.hprserverjava.mapper.hr.HrVisaMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:18:15 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrVisaService{

    private final HrVisaMapper hrVisaMapper;

    public MessageResult getEntity(HrVisa hrVisa){
        return MessageResult.success(hrVisaMapper.selectList(ObjectUtil.LikeWrapper(hrVisa,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrVisa hrVisa){
         return MessageResult.success(hrVisaMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrVisa,null)));
    }
        public MessageResult insertEntity(HrVisa hrVisa){
        String id = StringUtil.newID();
        hrVisa.setVisId(id);
        hrVisaMapper.insert(hrVisa);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrVisa hrVisa){
        return MessageResult.success(hrVisaMapper.updateById(hrVisa));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrVisaMapper.deleteById(id));
    }
}
