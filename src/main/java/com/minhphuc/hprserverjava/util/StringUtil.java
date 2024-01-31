package com.minhphuc.hprserverjava.util;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String newID(){
        return UUID.randomUUID().toString();
    }

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static MessageResult checkExistId(String id) {
        return (StringUtils.isBlank(id)) ?null: MessageResult.error("ID not found");
    }
}
