package com.minhphuc.hprserverjava.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.minhphuc.hprserverjava.domain.request.LanguageRequest;
import com.minhphuc.hprserverjava.domain.system.SystemLanguage;
import com.minhphuc.hprserverjava.mapper.system.SystemLanguageMapper;
import com.minhphuc.hprserverjava.util.LanguageUtil;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SystemLanguageService {

    private final SystemLanguageMapper systemLanguageMapper;


    public MessageResult getLanguage(String lan, String Page) {
        SystemLanguage systemLanguage = new SystemLanguage();
        systemLanguage.setMenuFk(Page);
        List<SystemLanguage> systemLanguages = systemLanguageMapper.selectList(new QueryWrapper<>(systemLanguage));
        return LanguageUtil.convertLanguageToObject(systemLanguages, lan);
    }

    public MessageResult getListSystem(SystemLanguage systemLanguage) {
        return MessageResult.success(systemLanguageMapper.selectList(ObjectUtil.LikeWrapper(systemLanguage, null)));
    }

    public MessageResult insertLanguage(SystemLanguage systemLanguage) {
        if (systemLanguage.getLanId() != null ) {
            return updateLanguage(systemLanguage);
        }
        String uuid = StringUtil.newID();
        systemLanguage.setLanId(uuid);
        systemLanguage.setLastUpdate(new Date());
        systemLanguageMapper.insert(systemLanguage);
        return MessageResult.success(uuid);
    }

    public MessageResult deleteLanguage(String id) {
        return MessageResult.success(systemLanguageMapper.deleteById(id));
    }

    public MessageResult updateLanguage(SystemLanguage systemLanguage) {
        if (systemLanguage.getLanId() == null) {
            return MessageResult.error("dont found language id");
        }
        //Get token info
        systemLanguage.setLastUpdate(new Date());
        systemLanguageMapper.updateById(systemLanguage);
        return MessageResult.success(systemLanguage.getLanId());
    }

    @Transactional
    public MessageResult updateLanguages(LanguageRequest systemLanguages) {
        for (SystemLanguage item : systemLanguages.getLanguages()) {
            item.setLastUpdate(new Date());
            systemLanguageMapper.updateById(item);
        }
        return MessageResult.success(null);
    }
}
