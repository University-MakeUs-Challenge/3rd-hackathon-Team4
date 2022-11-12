package com.team.health.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/umc?serverTimezone=UTC";
        String uid = "root";
        String upw = "family0831";

        return DriverManager.getConnection(url, uid, upw);
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            if(pstmt!=null) pstmt.close();
            if(conn != null) conn.close();
        }
        catch (SQLException e) {
            System.out.println("close 과정에서 에러 발생!");
        }
    }
}
