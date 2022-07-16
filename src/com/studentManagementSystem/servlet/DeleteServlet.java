package com.studentManagementSystem.servlet;

import com.studentManagementSystem.bean.User;
import com.studentManagementSystem.service.FileService;
import com.studentManagementSystem.service.FileServiceImpl;

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
 * @date 2022/7/16 20:13
 */
@WebServlet("/goDelete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        String studentId = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        boolean f = false;
        User user;
        ArrayList<User> u;
        try {
            f = fs.deleteStu(studentId);
            user = fs.getAdmin(userId);
            u = fs.getAllStudents();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("arrUser",u);
        req.setAttribute("user", user);
        if (f){
            req.setAttribute("message","删除成功");
        }else{
            req.setAttribute("message","删除失败");
        }
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
