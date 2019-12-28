package temp.dao;

import temp.db.DbClose;
import temp.db.DbConn;
import temp.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    //增删改查

    //增加
    public boolean addGoods(Goods goods){
        boolean flag = false;
        conn = DbConn.getconn();
        String sql = "insert into GOODS(GNAME, GPRICE, GNUM) VALUE(?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goods.getGname());
            pstmt.setDouble(2, goods.getGprice());
            pstmt.setInt(3, goods.getGnum());

            //是否添加成功
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

    //更改商品（价格，名称，数量）
    public boolean updateGoods(int key, Goods goods){
        boolean flag = false;
        conn = DbConn.getconn();

        switch (key){
            case 1: //更改商品名称
                    String sqlName = "update goods set gname=? where gid=?";

                    try {
                        pstmt = conn.prepareStatement(sqlName);
                        pstmt.setInt(2, goods.getGid());
                        pstmt.setString(1, goods.getGname());

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
            case 2: //更改商品价格
                    String sqlPrice = "update goods set gprice=? where gid = ?";
                    try {
                        pstmt = conn.prepareStatement(sqlPrice);
                        pstmt.setDouble(1, goods.getGprice());
                        pstmt.setInt(2, goods.getGid());

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
            case 3://	key=3,更改商品数量
                    String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";

                    try
                    {
                        pstmt = conn.prepareStatement(sqlNum);
                        pstmt.setInt(1, goods.getGnum());
                        pstmt.setInt(2,goods.getGid());

                        int rs = pstmt.executeUpdate();
                        if (rs > 0)
                        {
                            flag = true;
                        }
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }finally{
                        DbClose.addClose(pstmt,conn);
                    }

                break;
            default:
                break;
        }


        return flag;
    }


}
