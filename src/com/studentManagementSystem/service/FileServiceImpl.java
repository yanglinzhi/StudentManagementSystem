package com.studentManagementSystem.service;

import com.studentManagementSystem.Dao.FileDao;
import com.studentManagementSystem.Dao.FileDapImpl;
import com.studentManagementSystem.bean.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/14 15:40
 */
public class FileServiceImpl implements FileService{

    FileDao fs = new FileDapImpl();
    @Override
    public ArrayList<User> getAllStudents() throws SQLException, ClassNotFoundException {
        /*
        * 访问持久层
        * */
        return fs.getAllStudents();
    }

    @Override
    public User getFileByNameOrId(String v) throws SQLException, ClassNotFoundException {
        return fs.getFileByNameOrId(v);
    }

    @Override
    public User getAdmin(String id) throws SQLException, ClassNotFoundException {
        return fs.getAdmin(id);
    }

    @Override
    public boolean updatePsw(String sId, String sName, String newPsw) throws SQLException, ClassNotFoundException {
        return fs.updatePsw(sId,sName,newPsw);
    }

    @Override
    public boolean deleteStu(String studentId) throws SQLException, ClassNotFoundException {
        return fs.deleteStu(studentId);
    }
}

