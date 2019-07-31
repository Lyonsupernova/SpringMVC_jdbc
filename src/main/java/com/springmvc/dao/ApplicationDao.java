package com.springmvc.dao;

import java.sql.*; // import sql

import com.springmvc.models.ApplicationType; // import class Application Type
import org.springframework.stereotype.Repository;

import java.util.*; // import list

@Repository("applicationDao")
public class ApplicationDao {

    public List<ApplicationType> readTable() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ApplicationType> applicationTypeList = new ArrayList<ApplicationType>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8",
                            "root",
                            "123456");
            String sql = "select * from etl_application_type";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ApplicationType applicationType = new ApplicationType();
                applicationType.setID(rs.getInt(1));
                applicationType.setCode(rs.getInt(2));
                applicationType.setName(rs.getString(3));
                applicationType.setType(rs.getString(4));
                applicationType.setDescription(rs.getString(5));
                System.out.println(rs.getInt(1) + "------" +
                        rs.getString(2) +
                        "-----" + rs.getString(3) +
                        "-----" + rs.getString(4) +
                        "-----" + rs.getString(5));
                applicationTypeList.add(applicationType);
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
            return applicationTypeList;
        }
    }

    public boolean deleteTable(int index) {
        Connection conn =  null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8",
                            "root",
                            "123456");

            String sql = String.format("DELETE FROM etl_application_type WHERE S_PK_UUID = ?", index);
            ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
            System.out.println("Delete Successfully");
        } catch (SQLException e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                System.out.println("Connection closed already!");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean insertTable (String insertion) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8",
                            "root",
                            "123456");
            ps = conn.prepareStatement("INSERT INTO etl_application_type ('S_APPLICATION_CODE'," +
                    " 'S_APPLICATION_NAME', 'S_APP_TYPE', 'S_DESCRIPTION') VALUES (" + insertion + ")");
            i = ps.executeUpdate();
            System.out.println("Insert update successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                System.out.println("Connection closed already");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean updateTable(String updateName, String updateValue, String rowNumber) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8",
                    "root",
                    "123456");
            ps = conn.prepareStatement("UPDATE etl_application_type " + updateName + "=" + updateValue +
                    "WHERE S_PK_UUID = " + rowNumber);
            i = ps.executeUpdate();
            System.out.println("Update Successfully!");
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (i > 0) {
            return true;
        }
        return false;
    }


}


