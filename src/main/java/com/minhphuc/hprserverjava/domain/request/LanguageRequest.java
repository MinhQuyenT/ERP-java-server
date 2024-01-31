package com.minhphuc.hprserverjava.domain.request;

import com.minhphuc.hprserverjava.domain.system.SystemLanguage;
import lombok.Data;

import java.util.List;

@Data
public class LanguageRequest {

    private List<SystemLanguage> languages;
}
