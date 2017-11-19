package com.daejong.vip.function;

import com.daejong.vip.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DaeJong on 2017/4/7.
 */
public interface UserFunction {

    UserEntity login(String account, String password) throws Exception;

    @Transactional
    UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception;
}
