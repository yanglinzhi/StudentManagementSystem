package com.studentManagementSystem.service;

import com.studentManagementSystem.bean.User;

import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/12 19:01
 */
public interface loginService {

    User loginService(User u) throws SQLException, ClassNotFoundException;
}

