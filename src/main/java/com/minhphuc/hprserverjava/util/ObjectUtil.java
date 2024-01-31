package com.minhphuc.hprserverjava.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.minhphuc.hprserverjava.domain.view.ViewSystemPermisson;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class ObjectUtil {

    private static final String timeRegex = ",";

    @SneakyThrows
    public static <T> QueryWrapper<T> LikeWrapper(Object obj, List<ViewSystemPermisson> permissons) {
        QueryWrapper<T> wrapper = new QueryWrapper<T>();
        Class cls = obj.getClass();
        for (Field f : cls.getDeclaredFields()) {
            if( f.isAnnotationPresent(TableField.class)){
                TableField tableFieldAnnotation = f.getAnnotation(TableField.class);
                boolean exist = tableFieldAnnotation.exist();
                if(!exist){
                    continue;
                }
                if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) {
                    f.setAccessible(true);
                    Object var = f.get(obj);
                    if (var != null) {
                        FieldWhere(wrapper, f, var);
                        SortData(wrapper, f, var);
                    }
                }
            }else{
                if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) {
                    f.setAccessible(true);
                    Object var = f.get(obj);
                    if (var != null) {
                        FieldWhere(wrapper, f, var);
                        SortData(wrapper, f, var);
                    }
                }
            }
        }
        if(permissons!=null){
            PermissionUtil.getPermission(wrapper,permissons);
        }
        return wrapper;
    }

    @SneakyThrows
    private static <T> void FieldWhere(QueryWrapper<T> wrapper, Field field, Object value) {

        String fieldName = field.getName();

        if (field.getType().equals(String.class)) {
            String val = (String) value;
            String cleanVal = val.replace("%", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace("^^", "")
                    .replace("!^", "");
            if (cleanVal.length() == 0) {
                return;
            }

            if (val.contains("%")) {
                wrapper.like(StringUtils.isNotBlank(cleanVal), getTableFieldName(field), cleanVal);
                return;
            }

            if (fieldName.startsWith("r_") && fieldName.endsWith("_r")) {
                if (cleanVal.contains(timeRegex)) {
                    if (val.contains("[") && val.contains("]")) {
                        List<String> times = Arrays.asList(cleanVal.split(timeRegex));
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        wrapper.between(getTableFieldName(field)
                                , format.parse(times.get(0))
                                , format.parse(times.get(1)));
                        return;
                    }
                    if (val.contains("(") && val.contains(")")) {
                        List<String> times = Arrays.asList(cleanVal.split(timeRegex));
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        wrapper.gt(getTableFieldName(field), format.parse(times.get(0)))
                                .lt(getTableFieldName(field), format.parse(times.get(1)));
                        return;
                    }
                }
                if (cleanVal.length() == 10) {
                    String timeStart = cleanVal + " 00:00:00";
                    String timeEnd = cleanVal + " 23:59:59";
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    wrapper.between(getTableFieldName(field), format.parse(timeStart), format.parse(timeEnd));
                    return;
                }
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                wrapper.eq(cleanVal.length() > 0, getTableFieldName(field), format.parse(cleanVal));
                return;
            }
            wrapper.eq(value != null, getTableFieldName(field), value);
        }
    }

    @SneakyThrows
    private static <T> void SortData(QueryWrapper<T> wrapper, Field field, Object value) {
        if (field.getType().equals(String.class)) {
            String val = (String) value;
            if (val.contains("^^")) {
                System.out.println(val);
                wrapper.orderByAsc(getTableFieldName(field));
            }
            if (val.contains("!^")) {
                wrapper.orderByDesc(getTableFieldName(field));
            }
        }
    }

    private static String getTableFieldName(Field field) {
        TableField tf = field.getDeclaredAnnotation(TableField.class);
        if (tf != null && StringUtils.isNotBlank(tf.value())) {
            return tf.value();
        } else {
            String n = field.getName();
            if (n.startsWith("r_") && n.endsWith("_r")) {
                n = n.replace("r_", "").replace("_r", "");
            }
            return StringUtil.humpToLine(n);
        }
    }


}