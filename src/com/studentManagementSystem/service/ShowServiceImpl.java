package com.studentManagementSystem.service;

import com.studentManagementSystem.Dao.ShowDao;
import com.studentManagementSystem.Dao.ShowDaoImpl;
import com.studentManagementSystem.bean.Course;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/15 20:35
 */
public class ShowServiceImpl  implements ShowService{
    ShowDao sd = new ShowDaoImpl();


    @Override
    public ArrayList<Course> getScore(String studentId) throws SQLException, ClassNotFoundException {
        return sd.getScore(studentId);
    }
}
