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
        return salesManInfo;
    }


    /**
     * 2.添加售货员
     * @param sName 用户名
     * @return boolean
     */
    public boolean addSalseMan(SalesMan sName){
        boolean flag = false;

        conn = DbConn.getconn();
        String sql = "insert into salesman(sname, spassword) values ?, ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sName.getSName());
            pstmt.setString(2, sName.getSPassWord());

            int rs = pstmt.executeUpdate();
            if(rs > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.closeAll(pstmt, conn, rs);
        }


        return flag;
    }

    /**
     * 3.更改售货员信息
     * @param key 	要更改项
     * @param sName 用户名
     * @return boolean
     */
    public boolean updateSalesMan(int key, SalesMan sName){
        boolean flag = false;
        conn = DbConn.getconn();
        switch (key){
            case 1: //修改名字
                    String sqlSName = "update salesman set sName=? where sId=?";
                    try {
                        pstmt = conn.prepareStatement(sqlSName);
                        pstmt.setString(1, sName.getSName());
                        pstmt.setInt(2, sName.getSId());

                        int rs = pstmt.executeUpdate();
                        if(rs > 0){
                            flag = true;
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        DbClose.addClose(pstmt, conn);
                    }
                    break;
            case 2: //修改密码
                    String sqlSPWD = "update salesman set spassword=? where sid=?";
                try {
                    pstmt = conn.prepareStatement(sqlSPWD);
                    pstmt.setString(1, sName.getSPassWord());
                    pstmt.setInt(2, sName.getSId());

                    int rs = pstmt.executeUpdate();
                    if(rs > 0){
                        flag = true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DbClose.addClose(pstmt, conn);
                }
                break;
            default:
                DbClose.addClose(pstmt, conn);
                break;

        }


        return flag;
    }



    /**
     * 4.删除售货员
     * @param sName 用户名
     * @return boolean
     */
    public boolean deleteSalesMan(String sName){
        boolean flag = false;

        //不会存在重名的情况吗，是不是用sId删除更好一点
        String sql = "delete from sales where sname=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sName);

            int rs = pstmt.executeUpdate();
            if(rs > 0){
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.addClose(pstmt, conn);
        }


        return flag;
    }

    /**
     * 5.模糊查询售货员
     * @param sName 用户名
     * @return ArrayList<SalesMan>
     */
    public ArrayList<SalesMan> querySalesMan(String sName){
        ArrayList<SalesMan> SalesManList = new ArrayList<>();

        conn = DbConn.getconn();

        sName = "%" + sName + "%";
        String sql = "select * from salesman where sname like ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sName);

            rs = pstmt.executeQuery();

            while (rs.next()){
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                String spwd = rs.getString("spassword");

                SalesMan salesMan = new SalesMan(sid, sname, spwd);
                SalesManList.add(salesMan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.closeAll(pstmt, conn, rs);
        }
        return SalesManList;
    }

    /**
     * 6.显示所有售货员
     * @return ArrayList<SalesMan>
     */
    public ArrayList<SalesMan> queryAllSalesMan(){
        ArrayList<SalesMan> salesManArrayList = new ArrayList<>();

        conn = DbConn.getconn();
        String sql = "select * from salseman";

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()){
                int sId = rs.getInt("sid");
                String sName = rs.getString("sname");
                String sPwd = rs.getString("spassword");

                SalesMan salesMan = new SalesMan(sId, sName, sPwd);
                salesManArrayList.add(salesMan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.closeAll(pstmt, conn, rs);
        }


        return salesManArrayList;
    }
}
