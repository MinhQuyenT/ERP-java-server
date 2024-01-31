package com.minhphuc.hprserverjava.service.system;

import com.minhphuc.hprserverjava.domain.system.SystemPosition;
import com.minhphuc.hprserverjava.mapper.system.SystemPositionMapper;
import com.minhphuc.hprserverjava.util.MessageResult;
import com.minhphuc.hprserverjava.util.ObjectUtil;
import com.minhphuc.hprserverjava.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SystemPositionService {

    private final SystemPositionMapper systemPositionMapper;

    public MessageResult getEntity(SystemPosition systemPosition) {
        if (systemPosition.getPosName() != null) {
            List<SystemPosition> result = new ArrayList<>();
            systemPosition.setPosNameVi(systemPosition.getPosName());
            List<SystemPosition> vi = systemPositionMapper.selectList(ObjectUtil.LikeWrapper(systemPosition, null));

            systemPosition.setPosNameVi(null);
            systemPosition.setPosNameJa(systemPosition.getPosName());
            List<SystemPosition> jp = systemPositionMapper.selectList(ObjectUtil.LikeWrapper(systemPosition, null));

            systemPosition.setPosNameJa(null);
            systemPosition.setPosNameEn(systemPosition.getPosName());
            List<SystemPosition> en = systemPositionMapper.selectList(ObjectUtil.LikeWrapper(systemPosition, null));

            result.addAll(vi);
            result.addAll(jp);
            result.addAll(en);

            Set<SystemPosition> uniqueElements = new HashSet<>(result);
            result.clear();

            result.addAll(uniqueElements);
            return  MessageResult.success(result);
        }
        return MessageResult.success(systemPositionMapper.selectList(ObjectUtil.LikeWrapper(systemPosition, null)));
    }

    public MessageResult insertEntity(SystemPosition systemPosition) {
        String id = StringUtil.newID();
        systemPosition.setPosId(id);
        systemPosition.setCreateTime(new Date());
        systemPositionMapper.insert(systemPosition);
        return MessageResult.success(id);
    }

    public MessageResult updateEntity(SystemPosition systemPosition) {
        return MessageResult.success(systemPositionMapper.updateById(systemPosition));
    }

    public MessageResult deleteEntity(String id) {
        return MessageResult.success(systemPositionMapper.deleteById(id));
    }

}
