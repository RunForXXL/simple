package temp.dao;

import temp.db.DbClose;
import temp.db.DbConn;
import temp.entity.Gsales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GsalesDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 1、当天卖出的商品,待实现
     * @return ArrayList<Gsales>商品信息，包括allSum
     */
    public ArrayList<Gsales> dailyGsales(){
        ArrayList<Gsales> GsalesList = new ArrayList<>();

        String sql = "select gname, gprice, gnum, allSum from";


        return GsalesList;
    }

    public boolean shoppingSettlement(Gsales gsales){
        boolean flag = false;
        conn = DbConn.getconn();
        String sql = "insert into  gsales(gid, sid, snum) values(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gsales.getGId());
            pstmt.setInt(2, gsales.getSId());
            pstmt.setInt(3, gsales.getSNum());

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


}
