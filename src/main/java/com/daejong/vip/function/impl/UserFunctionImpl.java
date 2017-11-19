package com.daejong.vip.function.impl;

//静态导入的方式
import static com.daejong.common.AssertThrowUtil.*;

import com.daejong.common.ThisSystemException;
import com.daejong.vip.dao.UserDao;
import com.daejong.vip.entity.UserEntity;
import com.daejong.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DaeJong on 2017/4/7.
 */

@Service
public class UserFunctionImpl implements UserFunction{

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity login(String account, String password) throws Exception {

        account =  $("用户名不能为空", account);
        password = $("密码不能为空", password);

        UserEntity userEntity = userDao.select("account", account);
        if(userEntity == null) {
            throw new ThisSystemException("账户不存在");
        }
        if(!userEntity.getPassword().equals(password)) {
            throw new ThisSystemException("密码不正确");
        }
        return userEntity;
    }

    @Override
    public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1.验证参数
        id = $("id不能为空", id);
        oldPassword = $("旧密码必须填写", oldPassword);
        newPassword = $("新密码必须填写", newPassword);
        newPasswordConfirm = $("确定密码必须填写", newPasswordConfirm);
        assertEquals("两次密码不一致", newPassword, newPasswordConfirm);
        //2.找到用户
        UserEntity userEntity = userDao.select("id", id);
        assertNotNull("无法找到用户", userEntity);
        //3. 验证旧密码
        assertEquals("旧密码不正确", userEntity.getPassword(), oldPassword);
        //4. 更新密码
        userEntity.setPassword(newPassword);
        userDao.update(userEntity);
        return null;
    }
}
