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
 * @date 2022/7/14 17:01
 */
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String v = req.getParameter("v");
        //System.out.println(v);
        FileService fs = new FileServiceImpl();
        User u = null;
        try {
            u = fs.getFileByNameOrId(v);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<User> arr = new ArrayList<>();
        arr.add(u);
        String id = req.getParameter("id");
        FileService fs2 = new FileServiceImpl();
        User adminU = null;
        try {
            adminU = fs2.getAdmin(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user",adminU);
        if(u!=null){
            req.setAttribute("arrUser",arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);

        }else {
            FileService f = new FileServiceImpl();
            ArrayList<User> arr2;
            try {
                arr2 = f.getAllStudents();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("arrUser", arr2);
            req.setAttribute("message","none");
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        }

    }
}
