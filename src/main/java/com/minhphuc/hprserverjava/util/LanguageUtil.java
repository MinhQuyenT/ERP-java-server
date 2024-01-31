package com.minhphuc.hprserverjava.util;

import com.minhphuc.hprserverjava.domain.system.SystemLanguage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageUtil {

    public static MessageResult convertLanguageToObject(List<SystemLanguage> languageList,String lan){
        Map<String,String> result = new HashMap<>();
        for (SystemLanguage item:languageList){
            switch (lan){
                case "en":
                    result.put(item.getLanKey(),item.getEn());
                    break;
                case "vi":
                    result.put(item.getLanKey(),item.getVi());
                    break;
                case "jp":
                    result.put(item.getLanKey(),item.getJp());
                    break;
            }
        }
        return MessageResult.success(result);
    }
}
