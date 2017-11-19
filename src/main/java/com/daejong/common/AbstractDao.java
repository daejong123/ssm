package com.daejong.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by DaeJong on 2017/4/12.
 */
public interface AbstractDao<T> {

    void insert(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(@Param("key") String ukfield, @Param("value") Object value) throws Exception;

    T select(@Param("key") String ukfield, @Param("value") Object value) throws Exception;

    boolean exists(@Param("key") String ukfield, @Param("value") Object value) throws Exception;

    List<T> selectLike(Map<String, Object> map) throws Exception;

}
