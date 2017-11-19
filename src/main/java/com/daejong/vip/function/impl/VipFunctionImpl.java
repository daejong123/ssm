package com.daejong.vip.function.impl;

import com.daejong.vip.dao.VipDao;
import com.daejong.vip.entity.VipEntity;
import com.daejong.vip.function.VipFunction;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DaeJong on 2017/4/12.
 */
@Service
public class VipFunctionImpl implements VipFunction {

    @Autowired
    private VipDao vipDao;

    /**
     * 单个数据进行查询, 根据id进行搜索
     */
    @Override
    public VipEntity selectById(@Param("id") String id) throws Exception {
        //参数进行验证
        VipEntity vipEntity = vipDao.select("id", id);
        return vipEntity;
    }
    /**
     * 进行模糊查询
     */
    @Override
    public List<VipEntity> selectLike(Map<String ,Object> map) throws Exception {
        List<VipEntity> list = vipDao.selectLike(map);
        return list;
    }
}
