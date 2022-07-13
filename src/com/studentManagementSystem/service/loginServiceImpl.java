package com.studentManagementSystem.service;

import com.studentManagementSystem.Dao.LoginDao;
import com.studentManagementSystem.Dao.LoginDaoImpl;
import com.studentManagementSystem.bean.User;

import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/12 19:01
 */
public class loginServiceImpl implements loginService{


    @Override
    public User loginService(User u) throws SQLException, ClassNotFoundException {
        LoginDao ld = new LoginDaoImpl();
        return ld.loginDao(u);
    }
}

