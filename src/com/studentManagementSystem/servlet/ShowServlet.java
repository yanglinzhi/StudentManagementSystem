package com.studentManagementSystem.servlet;

import com.studentManagementSystem.bean.Course;
import com.studentManagementSystem.bean.User;
import com.studentManagementSystem.service.FileService;
import com.studentManagementSystem.service.FileServiceImpl;
import com.studentManagementSystem.service.ShowService;
import com.studentManagementSystem.service.ShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/15 20:11
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * 查看个人成绩
         * */
        req.setCharacterEncoding("utf-8");
        String UserId = req.getParameter("id");
        String StudentId = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        ShowService ss = new ShowServiceImpl();
        User adminU;
        User student;
        try {
            adminU = fs.getAdmin(UserId);
            student = fs.getAdmin(StudentId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Course> course;
        try {
            course = ss.getScore(StudentId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user", adminU);
        req.setAttribute("student", student);
        req.setAttribute("arrStudent", course);
        req.getRequestDispatcher("score.jsp").forward(req, resp);

    }
}
