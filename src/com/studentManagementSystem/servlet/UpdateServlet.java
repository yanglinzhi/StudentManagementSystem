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

/**
 * @author ylz
 * @date 2022/7/16 13:34
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uId = req.getParameter("uId");
        String sId = req.getParameter("sId");
        String sName = req.getParameter("sName");
        String oldPsw = req.getParameter("oldPsw");
        String newPsw = req.getParameter("newPsw");
        FileService fs = new FileServiceImpl();
        User S = null;
        User U = null;
        try {
            U = fs.getAdmin(uId);
            S = fs.getAdmin(sId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user",U);
        req.setAttribute("student",S);
        if (S.getU_pwd().equals(oldPsw)){
            boolean s;
            try {
                s = fs.updatePsw(sId,sName,newPsw);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if(s){
                req.setAttribute("message","修改成功");
            }else{
                req.setAttribute("message","修改失败");
            }
        }else{
            req.setAttribute("message","原密码不正确");
        }
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
