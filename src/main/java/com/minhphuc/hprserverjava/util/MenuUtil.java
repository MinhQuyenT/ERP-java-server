package com.minhphuc.hprserverjava.util;

import com.minhphuc.hprserverjava.domain.response.MenuResponse;
import com.minhphuc.hprserverjava.domain.system.SystemMenu;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuUtil {

    public static List<MenuResponse> getMenu(List<SystemMenu> systemMenus) {

        List<MenuResponse> modules = new ArrayList<>();

        for (SystemMenu item : systemMenus) {
            if (item.getMenuType() == 1){
                MenuResponse menuResponse = new MenuResponse();
                BeanUtils.copyProperties(item, menuResponse);
                modules.add(menuResponse);
            }
        };

        for (MenuResponse item : modules) {
            item.setChildren(getchildren(systemMenus, item));
        };

        return modules;

    }

    public static List<MenuResponse> getchildren(List<SystemMenu> systemMenus, MenuResponse menuResponse) {

        List<MenuResponse> menuResponses = new ArrayList<>();
        for (SystemMenu item : systemMenus) {
            if (Objects.equals(item.getParentId(), menuResponse.getMenuId()) && item.getMenuType() == 2) {
                MenuResponse menuResponse1 = new MenuResponse();
                BeanUtils.copyProperties(item, menuResponse1);
                menuResponse1.setChildren(getchildren(systemMenus,menuResponse1));
                menuResponses.add(menuResponse1);
            }
        }
        return menuResponses;
    }



}
