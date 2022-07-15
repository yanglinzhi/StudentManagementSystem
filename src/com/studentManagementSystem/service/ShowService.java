package com.studentManagementSystem.service;

import com.studentManagementSystem.bean.Course;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/15 20:34
 */
public interface ShowService {


    ArrayList<Course> getScore(String studentId) throws SQLException, ClassNotFoundException;
}
