package com.minhphuc.hprserverjava.service.hr;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.hr.HrContract;
import com.minhphuc.hprserverjava.domain.view.ViewHrContract;
import com.minhphuc.hprserverjava.mapper.hr.HrContractMapper;
import com.minhphuc.hprserverjava.mapper.view.ViewHrContractMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 /**
 * Automatically generate code by Minh Phúc
 * @author Minh Phúc
 * @date Thu Sep 07 08:15:23 GMT+07:00 2023
 */
@Service
@RequiredArgsConstructor
public class HrContractService{

    private final HrContractMapper hrContractMapper;
    private final ViewHrContractMapper viewHrContractMapper;

    public MessageResult getEntity(HrContract hrContract){
        return MessageResult.success(viewHrContractMapper.selectList(ObjectUtil.LikeWrapper(hrContract,null)));
    }

    public MessageResult getEntityPage(PageUtil pageUtil,HrContract hrContract){
         return MessageResult.success(viewHrContractMapper.selectPage(new Page<>(pageUtil.getStart(),pageUtil.getRows()),ObjectUtil.LikeWrapper(hrContract,null)));
    }
        public MessageResult insertEntity(HrContract hrContract){
        String id = StringUtil.newID();
        hrContract.setConId(id);
        hrContractMapper.insert(hrContract);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(HrContract hrContract){
        return MessageResult.success(hrContractMapper.updateById(hrContract));
    }

    public MessageResult deleteEntity(String id){
        return MessageResult.success(hrContractMapper.deleteById(id));
    }
}
