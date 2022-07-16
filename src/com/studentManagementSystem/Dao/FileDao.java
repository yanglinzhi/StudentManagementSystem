package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/14 15:42
 */
public interface FileDao {
    ArrayList<User> getAllStudents() throws SQLException, ClassNotFoundException;

    User getFileByNameOrId(String v) throws SQLException, ClassNotFoundException;

    User getAdmin(String id) throws SQLException, ClassNotFoundException;


    boolean updatePsw(String sId, String sName, String newPsw) throws SQLException, ClassNotFoundException;
}
