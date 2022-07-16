package com.studentManagementSystem.Dao;

import com.studentManagementSystem.bean.User;
import com.studentManagementSystem.util.conntionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ylz
 * @date 2022/7/14 15:42
 */
public class FileDapImpl implements FileDao{
    /*
    * 获取所有数据库信息
    *
    * */
    @Override
    public ArrayList<User> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<User> arr = new ArrayList<>();
        //访问数据库
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        String sql = "SELECT * FROM user WHERE u_role=1 AND u_isdelete=0";
        ResultSet rs = cF.dbSelect(sql);
        while (rs.next()){
            User user = new User();
            user.setU_id(rs.getInt("u_id"));
            user.setU_name(rs.getString("u_name"));
            user.setU_pwd(rs.getString("u_pwd"));
            user.setU_phone(rs.getString("u_phone"));
            user.setU_role(rs.getInt("u_role"));
            user.setIsdelete(rs.getInt("u_isdelete"));
            arr.add(user);
        }
        rs.close();
        cF.close();
        return arr;
    }

    @Override
    public User getFileByNameOrId(String v) throws SQLException, ClassNotFoundException {
        /*
        * 写sql语言拿特定对象
        * */
        String sql = "SELECT * FROM user WHERE u_name='"+v+"'";
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        ResultSet rs = cF.dbSelect(sql);
        while (rs.next()){
            User user = new User();
            user.setU_id(rs.getInt("u_id"));
            user.setU_name(rs.getString("u_name"));
            user.setU_pwd(rs.getString("u_pwd"));
            user.setU_phone(rs.getString("u_phone"));
            user.setU_role(rs.getInt("u_role"));
            user.setIsdelete(rs.getInt("u_isdelete"));
            return user;
        }
        return null;
    }

    @Override
    public User getAdmin(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE u_id='"+id+"'";
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        ResultSet rs = cF.dbSelect(sql);
        while (rs.next()){
            User user = new User();
            user.setU_id(rs.getInt("u_id"));
            user.setU_name(rs.getString("u_name"));
            user.setU_pwd(rs.getString("u_pwd"));
            return user;
        }
        return null;
    }

    @Override
    public boolean updatePsw(String sId, String sName, String newPsw) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET u_pwd="+newPsw+" WHERE u_id="+sId+" AND u_name="+sName;
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        conntionFactory cF = new conntionFactory(url,username,password);
        int rs= cF.dbUpdate(sql);
        if (rs == 1){
            return true;
        }else{
            return false;
        }
    }
}
