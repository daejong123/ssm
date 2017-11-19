package com.daejong.vip.function;

import com.daejong.vip.entity.VipEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by DaeJong on 2017/4/12.
 */
public interface VipFunction {

    VipEntity selectById(@Param("id") String id) throws Exception;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    List<VipEntity> selectLike(Map<String, Object> map) throws Exception;
}

