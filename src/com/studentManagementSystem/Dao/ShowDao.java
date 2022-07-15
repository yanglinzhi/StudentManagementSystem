package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.Course;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/15 20:35
 */
public interface ShowDao {

    ArrayList<Course> getScore(String studentId) throws SQLException, ClassNotFoundException;
}
