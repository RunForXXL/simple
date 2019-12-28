package temp.dao;

import temp.db.DbClose;
import temp.db.DbConn;
import temp.entity.SalesMan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesManDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 1.前台收银登陆
     * @param sName 用户名
     * @return ArrayList<SalesMan> sPassWord,sId
     */
    public ArrayList<SalesMan> checkstandLog(String sName){
        ArrayList<SalesMan> salesManInfo = new ArrayList<SalesMan>();
        conn = DbConn.getconn();
        String sql = "select sid, spassword from salesman where sname = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sName);

            rs = pstmt.executeQuery();
            while(rs.next()){
                String sPWD = rs.getString("spassword");
                int sid = rs.getInt("sid");
                SalesMan salesMan = new SalesMan(sid, sPWD);
                salesManInfo.add(salesMan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.closeAll(pstmt,conn, rs);
        }
    }


    /**
     * 2.添加售货员
     * @param sName 用户名
     * @return boolean
     */

    /**
     * 3.更改售货员信息
     * @param key 	要更改项
     * @param sName 用户名
     * @return boolean
     */

    /**
     * 4.删除售货员
     * @param sName 用户名
     * @return boolean
     */

    /**
     * 5.模糊查询售货员
     * @param sName 用户名
     * @return ArrayList<SalesMan>
     */

    /**
     * 6.显示所有售货员
     * @return ArrayList<SalesMan>
     */
}
