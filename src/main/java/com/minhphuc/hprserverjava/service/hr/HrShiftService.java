package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrShift;
import com.minhphuc.hprserverjava.mapper.hr.HrShiftMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:17:23 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrShiftService{

    private final HrShiftMapper hrShiftMapper;

    public MessageResult getEntity(HrShift hrShift){
        return MessageResult.success(hrShiftMapper.selectList(ObjectUtil.LikeWrapper(hrShift,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrShift hrShift){
         return MessageResult.success(hrShiftMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrShift,null)));
    }
        public MessageResult insertEntity(HrShift hrShift){
        String id = StringUtil.newID();
        hrShift.setShiId(id);
        hrShiftMapper.insert(hrShift);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrShift hrShift){
        return MessageResult.success(hrShiftMapper.updateById(hrShift));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrShiftMapper.deleteById(id));
    }
}
