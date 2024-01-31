package com.minhphuc.hprserverjava.service.system;

import com.minhphuc.hprserverjava.domain.system.SystemMenu;
import com.minhphuc.hprserverjava.mapper.system.SystemMenuMapper;
import com.minhphuc.hprserverjava.util.MenuUtil;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemMenuService{

    private final SystemMenuMapper systemMenuMapper;

    public MessageResult getListMenu(SystemMenu systemMenu){
        List<SystemMenu> systemMenuList = systemMenuMapper.selectList(ObjectUtil.LikeWrapper(systemMenu,null));
        return MessageResult.success(MenuUtil.getMenu(systemMenuList));
    }

    public MessageResult getSystemAccount(SystemMenu systemMenu){
        systemMenu.setMenuType(2);
        return MessageResult.success(systemMenuMapper.selectList(ObjectUtil.LikeWrapper(systemMenu,null)));
    }

    public MessageResult insertSystemMenu(SystemMenu systemMenu){
        systemMenu.setMenuId(StringUtil.newID());
        systemMenu.setCreateTime(new Date());
        systemMenu.setMenuId(StringUtil.newID());
        return MessageResult.success(systemMenuMapper.insert(systemMenu));
    }

    public MessageResult updateSystemMenu(SystemMenu systemMenu){

        return MessageResult.success(systemMenuMapper.updateById(systemMenu));
    }

    public MessageResult deleteSystemMenu(SystemMenu systemMenu){
        return MessageResult.success(systemMenuMapper.selectList(ObjectUtil.LikeWrapper(systemMenu,null)));
    }



}
