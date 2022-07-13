package com.studentManagementSystem.servlet;

import com.studentManagementSystem.bean.User;
import com.studentManagementSystem.service.loginService;
import com.studentManagementSystem.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/12 15:17
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html;charset=UTF-8");
        String u_id = req.getParameter("u_id");
        String u_pwd = req.getParameter("u_pwd");
        System.out.println(u_id+","+u_pwd);
        User u = new User();
        u.setU_id(Integer.parseInt(u_id));
        u.setU_pwd(u_pwd);
        Integer U_id = Integer.parseInt(u_id);
//        System.out.println("账户："+ u.getU_id()+"密码："+u.getU_pwd());
        //实现登录服务层的业务逻辑层
        loginService l = new loginServiceImpl();
        User user = null;
        try {
            user = l.loginService(u);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(U_id.equals(user.getU_id())&&u_pwd.equals(user.getU_pwd())){
            req.setAttribute("user",user);
            //说明确有其值
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else {

        }
    }
}
