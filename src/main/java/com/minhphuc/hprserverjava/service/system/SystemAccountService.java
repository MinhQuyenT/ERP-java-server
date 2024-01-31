package com.minhphuc.hprserverjava.service.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.minhphuc.hprserverjava.domain.system.SystemAccount;
import com.minhphuc.hprserverjava.domain.system.SystemMenu;
import com.minhphuc.hprserverjava.mapper.system.SystemAccountMapper;
import com.minhphuc.hprserverjava.mapper.system.SystemMenuMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.PageUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SystemAccountService {

    private final SystemAccountMapper systemAccountMapper;

    public MessageResult getAccountList(SystemAccount systemAccount){
        systemAccount.setDelFlag(0);
        return MessageResult.success(systemAccountMapper.selectList(ObjectUtil.LikeWrapper(systemAccount,null)));
    }

    public MessageResult getAccountListbyPage(SystemAccount systemAccount, PageUtil page){
        IPage<SystemAccount> systemAccountIPage = systemAccountMapper.selectPage(new Page<>(page.getStart(),page.getRows())
                ,ObjectUtil.LikeWrapper(systemAccount,null));
        return MessageResult.success(systemAccountIPage);
    }

    public MessageResult insertAccount(SystemAccount systemAccount){
        String id = StringUtil.newID();
        systemAccount.setAccountId(id);
        systemAccount.setDelFlag(0);
        systemAccountMapper.insert(systemAccount);
        return MessageResult.success(id);
    }

    public MessageResult updateAccount(SystemAccount systemAccount){
        return MessageResult.success(systemAccountMapper.updateById(systemAccount));
    }

    public MessageResult deleteAccount(String id){
        SystemAccount systemAccount = systemAccountMapper.selectById(id);
        if(systemAccount==null){
            return MessageResult.error("dont found id");
        }
        systemAccount.setDelFlag(1);
        systemAccount.setDelTime(new Date());
        systemAccountMapper.updateById(systemAccount);
        return MessageResult.success(systemAccountMapper.deleteById(id));
    }

}
