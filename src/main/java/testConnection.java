package com.springmvc;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

public class testConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8", "root", "123456");
        String sql = "select * from etl_application_type";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1)+"------"+rs.getString(2)+"-----"+rs.getString(3)+"-----"+rs.getString(4)+"-----"+rs.getString(5));
        }
        rs.close();
        ps.close();
        conn.close();
        }
    }
