package com.studentManagementSystem.util;

import java.sql.*;

/**
 * @author ylz
 * @date 2022/7/13 11:21
 */
public class conntionFactory {
    private String url;
    private String username;
    private String psw;
    private Connection conn = null;
    private Statement stmt = null;
    public conntionFactory() throws SQLException {
    }

    public conntionFactory(String url, String username, String psw) throws SQLException {
        this.url = url;
        this.username = username;
        this.psw = psw;
//        Connection coon = DriverManager.getConnection(url,username,psw);
//        String sql = "UPDATE user SET u_phone=5678 WHERE u_id=1";
//        Statement stmt = coon.createStatement();
//        //5.执行update语句
//        int count =  stmt.executeUpdate(sql);//返回受影响行数
//        //6.处理结果
//        System.out.println(count);
//        //7.释放资源
//        stmt.close();
//        coon.close();
    }
    public void getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(this.url,this.username,this.psw);
        stmt = conn.createStatement();
    }
    //增，删，改
    public int dbUpdate(String sql) throws SQLException, ClassNotFoundException {
        getConnection();
        int count =  stmt.executeUpdate(sql);
        return count;
    }
    //查
    public ResultSet dbSelect(String sql) throws SQLException, ClassNotFoundException {
        getConnection();
        ResultSet rs =  stmt.executeQuery(sql) ;
        return rs;
    }
    public  void close() throws SQLException {
        stmt.close();
        conn.close();
    }
}
