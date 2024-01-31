package com.minhphuc.hprserverjava.service.view;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.minhphuc.hprserverjava.domain.view.ViewSystemPermisson;
import com.minhphuc.hprserverjava.mapper.view.ViewSystemPermissionMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.PermissionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewSystemPermissionService {

    private final ViewSystemPermissionMapper viewSystemPermissionMapper;

    public List<ViewSystemPermisson> get(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String currentURL = request.getRequestURL().toString();
        String api = currentURL.substring(currentURL.indexOf("/api/v1/"),currentURL.length());
        String method = request.getMethod();
        System.out.println("Request method: " + method);
        QueryWrapper queryWrapper = new QueryWrapper<ViewSystemPermisson>().eq("id","2").eq("path",api);
        return viewSystemPermissionMapper.selectList(queryWrapper);
    }

    public MessageResult checkPermissions() {
        List<ViewSystemPermisson> permissions = get();
        return PermissionUtil.checkPermission(permissions) ? null : MessageResult.errorNotPerm();
    }
}
