package com.studentManagementSystem.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ylz
 * @date 2022/7/13 12:33
 */
public class jdbcTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/studenttest";
        String username = "root";
        String password = "root";
        String sql = "Select * from user ";
        conntionFactory cF = new conntionFactory(url,username,password);
        ResultSet rs = cF.dbSelect(sql);
        while (rs.next()){
            String deptno=rs.getString("u_id");
            String dname=rs.getString(2);
            String loc=rs.getString(3);
            System.out.println("deptno:"+deptno+",dname:"+dname+",loc:"+loc);
        }
        rs.close();
        cF.close();
    }
}
