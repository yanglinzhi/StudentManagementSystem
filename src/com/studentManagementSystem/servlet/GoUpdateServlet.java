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
 * @date 2022/7/16 8:42
 */
@WebServlet("/goUpdate")
public class GoUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Course> course;
        try {
            course = ss.getScore(StudentId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user", adminU);
        req.setAttribute("student", student);
        req.setAttribute("message","none");
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
