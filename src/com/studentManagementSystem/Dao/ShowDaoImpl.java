package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.Course;
import com.studentManagementSystem.util.conntionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/15 20:36
 */
public class ShowDaoImpl implements ShowDao{


    @Override
    public ArrayList<Course> getScore(String studentId) throws SQLException, ClassNotFoundException {
        ArrayList<Course> arr = new ArrayList<>();
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        String sql = "SELECT " +
                "course.*," +
                "userchoose.c_score " +
                "FROM " +
                "USER," +
                "course," +
                "userchoose " +
                "WHERE " +
                "USER.u_id = userchoose.u_id " +
                "AND course.c_id = userchoose.c_id " +
                "AND USER.u_id ="+studentId;
        ResultSet rs = cF.dbSelect(sql);
        while (rs.next()){
            Course course = new Course();
            course.setCourseId(rs.getInt("c_id"));
            course.setCourseName(rs.getString("c_name"));
            course.setCourseTeacherName(rs.getString("c_teacher"));
            course.setCourseScore(rs.getInt("c_score"));
            arr.add(course);
        }
        rs.close();
        cF.close();
        return arr;
    }
}

