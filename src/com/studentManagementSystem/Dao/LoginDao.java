package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.User;

import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/12 19:02
 */
public interface LoginDao {
    User loginDao(User u) throws SQLException, ClassNotFoundException;
}
