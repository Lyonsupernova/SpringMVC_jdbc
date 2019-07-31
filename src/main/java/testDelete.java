package com.springmvc;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.sql.DriverManager;


public class testDelete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT", "root", "123456");
        String sql = "DELETE FROM etl_application_type WHERE S_PK_UUID = 22";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        System.out.println("Delete Successfully");
        conn.close();
        ps.close();
        System.out.println("Connection closed already!");
        }
}



