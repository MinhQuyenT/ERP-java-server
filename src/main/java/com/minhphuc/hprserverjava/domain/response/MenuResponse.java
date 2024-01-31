package com.minhphuc.hprserverjava.domain.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class MenuResponse {

    private String menuId;

    private String parentId;

    private String path;

    private String menuName;

    private String icon;

    private Integer sn;

    private List<MenuResponse> children;

}
