package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrShiftDtl;
import com.minhphuc.hprserverjava.mapper.hr.HrShiftDtlMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:43 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrShiftDtlService{

    private final HrShiftDtlMapper hrShiftDtlMapper;

    public MessageResult getEntity(HrShiftDtl hrShiftDtl){
        return MessageResult.success(hrShiftDtlMapper.selectList(ObjectUtil.LikeWrapper(hrShiftDtl,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrShiftDtl hrShiftDtl){
         return MessageResult.success(hrShiftDtlMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrShiftDtl,null)));
    }
        public MessageResult insertEntity(HrShiftDtl hrShiftDtl){
        String id = StringUtil.newID();
        hrShiftDtl.setShiDtlId(id);
        hrShiftDtlMapper.insert(hrShiftDtl);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrShiftDtl hrShiftDtl){
        return MessageResult.success(hrShiftDtlMapper.updateById(hrShiftDtl));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrShiftDtlMapper.deleteById(id));
    }
}
