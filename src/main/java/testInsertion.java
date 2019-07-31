package com.springmvc;

import java.sql.*;

public class testInsertion {
    public static void main(String[] args) throws SQLException {
        // get connection to mysql with url(utl-8 format, Shanghai timezone)
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8",
                "root",
                "123456");
        // Set MySQL command to insert into code 06 name over watch Game to the esl_application_type
        String sql = "INSERT INTO etl_application_type (S_APPLICATION_CODE, S_APPLICATION_NAME, S_APP_TYPE, S_DESCRIPTION) VALUES (06, 'overwatch', 'game', '06overwatch' )";
        // create prepare statement object
        PreparedStatement ps = conn.prepareStatement(sql);
        // we don't use executeQuery here as it didn't ask for the result from mySQL
        ps.executeUpdate();
        System.out.println("insert successfully!");
        // close the connection from preparedStatement and connection pool
        ps.close();
        conn.close();
    }
}
