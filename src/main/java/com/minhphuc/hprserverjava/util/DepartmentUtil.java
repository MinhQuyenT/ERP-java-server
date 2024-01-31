package com.minhphuc.hprserverjava.util;

import com.minhphuc.hprserverjava.domain.response.TreeRespone;
import com.minhphuc.hprserverjava.domain.system.SystemDepartment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentUtil {

    public static List<TreeRespone> convertTree(List<SystemDepartment> departmentList, String lan) {
        List<TreeRespone> responeList = new ArrayList<>();
        for (SystemDepartment item : departmentList) {
            if (item.getParentId() == null || item.getParentId().equals("")) {
                TreeRespone treeRespone = new TreeRespone();
                String title = "";
                if (lan == null) {
                    lan = "vi";
                }
                switch (lan) {
                    case "vi":
                        title = item.getDptNameVi();
                        break;

                    case "en":
                        title = item.getDptNameEn();
                        break;

                    case "ja":
                        title = item.getDptNameJp();
                        break;
                    default:
                        title = item.getDptNameVi();
                        break;
                }
                treeRespone.setTitle(title);
                treeRespone.setKey(item.getDpUuid());

                List<SystemDepartment> systemDepartments = departmentList.stream().filter((e) ->
                        {
                            String parentId = e.getParentId();
                            return parentId != null && parentId.equals(item.getDpUuid());
                        }
                ).collect(Collectors.toList());
                if (systemDepartments.size() > 0) {
                    treeRespone.setChildren(convertTreeItem(departmentList, systemDepartments, lan));
                }
                responeList.add(treeRespone);
            }
        }
        return responeList;
    }

    public static List<TreeRespone> convertTreeItem(List<SystemDepartment> alldata, List<SystemDepartment> systemDepartment, String lan) {

        List<TreeRespone> result = new ArrayList<>();
        for (SystemDepartment item : systemDepartment) {
            TreeRespone treeRespone = new TreeRespone();
            String title = "";
            treeRespone.setKey(item.getDpUuid());
            if (lan == null) {
                lan = "vi";
            }
            switch (lan) {
                case "vi":
                    title = item.getDptNameVi();
                    break;

                case "en":
                    title = item.getDptNameEn();
                    break;

                case "ja":
                    title = item.getDptNameJp();
                    break;
                default:
                    title = item.getDptNameVi();
                    break;
            }
            treeRespone.setTitle(title);
            List<SystemDepartment> systemDepartments = alldata.stream().filter((e) ->
                    {
                        String parentId = e.getParentId(); // Lấy parentId
                        return parentId != null && parentId.equals(item.getDpUuid());
                    }
            ).collect(Collectors.toList());
            if (systemDepartments.size() > 0) {
                treeRespone.setChildren(convertTreeItem(alldata, systemDepartments, lan));
            }
            result.add(treeRespone);
        }
        return result;
    }
}
