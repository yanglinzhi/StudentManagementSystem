package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.User;

/**
 * @author ylz
 * @date 2022/7/12 19:02
 */
public class LoginDaoImpl implements LoginDao{

    @Override
    public User loginDao(User u) {
        //写数据库
        int id = u.getU_id();
        String pwd = u.getU_pwd();
        //访问数据库
        User user = new User(1001, "小明","1","17600000000",1,0);
        return user;
    }
}

