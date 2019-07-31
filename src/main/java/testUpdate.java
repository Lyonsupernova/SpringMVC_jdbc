package com.springmvc;

    import java.sql.Connection;

    import java.sql.PreparedStatement;

    import java.sql.SQLException;

    import java.sql.DriverManager;

public class testUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=CTT", "root", "123456");
        String sql = "UPDATE test.etl_application_type SET S_APPLICATION_NAME =  'Heathens' WHERE S_PK_UUID = 22";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        System.out.println("Update Successfully!");
        conn.close();
        ps.close();
        System.out.println("Database closed already");
    }
}
