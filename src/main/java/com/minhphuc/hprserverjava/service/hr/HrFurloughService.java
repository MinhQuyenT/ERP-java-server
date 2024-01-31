package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrFurlough;
import com.minhphuc.hprserverjava.mapper.hr.HrFurloughMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Wed Sep 13 13:06:02 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrFurloughService{

    private final HrFurloughMapper hrFurloughMapper;

    public MessageResult getEntity(HrFurlough hrFurlough){
        return MessageResult.success(hrFurloughMapper.selectList(ObjectUtil.LikeWrapper(hrFurlough,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrFurlough hrFurlough){
         return MessageResult.success(hrFurloughMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrFurlough,null)));
    }
        public MessageResult insertEntity(HrFurlough hrFurlough){
        String id = StringUtil.newID();
        hrFurlough.setFurId(id);
        hrFurloughMapper.insert(hrFurlough);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrFurlough hrFurlough){
        return MessageResult.success(hrFurloughMapper.updateById(hrFurlough));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrFurloughMapper.deleteById(id));
    }
}
