package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.User;
import com.studentManagementSystem.util.conntionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/12 19:02
 */
public class LoginDaoImpl implements LoginDao{

    @Override
    public User loginDao(User u) throws SQLException, ClassNotFoundException {
        //写数据库
        int id = u.getU_id();
        String pwd = u.getU_pwd();
        //访问数据库
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        String sql = "SELECT * FROM user WHERE u_id="+id+" and u_pwd="+pwd;
        ResultSet rs = cF.dbSelect(sql);
        User user = new User();
        while (rs.next()){
            user.setU_id(rs.getInt("u_id"));
            user.setU_name(rs.getString("u_name"));
            user.setU_pwd(rs.getString("u_pwd"));
            user.setU_phone(rs.getString("u_phone"));
            user.setU_role(rs.getInt("u_role"));
            user.setIsdelete(rs.getInt("u_isdelete"));
        }
        return user;
    }
}

