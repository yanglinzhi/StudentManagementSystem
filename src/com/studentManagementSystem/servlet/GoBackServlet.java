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
 * @date 2022/7/16 8:16
 */
@WebServlet("/goBack")
public class GoBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        FileService fs = new FileServiceImpl();
        ArrayList<User> arrUser = null;
        User user = null;
        try {
            user=fs.getAdmin(id);
            arrUser = fs.getAllStudents();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user",user);
        req.setAttribute("arrUser",arrUser);
        //说明确有其值
        req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
    }
}
