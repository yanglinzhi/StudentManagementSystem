package com.studentManagementSystem.service;

import com.studentManagementSystem.Dao.LoginDao;
import com.studentManagementSystem.Dao.LoginDaoImpl;
import com.studentManagementSystem.bean.User;

/**
 * @author ylz
 * @date 2022/7/12 19:01
 */
public class loginServiceImpl implements loginService{


    @Override
    public User loginService(User u) {
        LoginDao ld = new LoginDaoImpl();
        return ld.loginDao(u);
    }
}

