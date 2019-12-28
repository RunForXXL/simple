package temp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbClose {
    public static void addClose(PreparedStatement pstmt, Connection conn){
        try {
            if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(PreparedStatement pstmt, Connection conn, ResultSet rs){
        try {
            if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
