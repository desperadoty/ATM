package dao;

import com.po.Transfer;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/9.
 * 与transfer表相关操作
 * 功能：添加转账交易记录
 */
public class TransferDAO {

    //获取当前时间
    private static String getCurrentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now = new Date();
        return sdf.format(now);
    }


    //转账记录
    public boolean addTransferInfo(Transfer transfer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int a = 0;
        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "INSERT INTO transfer(transferout,transferin,amount,transferdate) VALUES(?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,transfer.getTransferout());
            stmt.setString(2,transfer.getTransferin());
            stmt.setDouble(3,transfer.getAmount());
            stmt.setString(4,getCurrentTimeStamp());
            a = stmt.executeUpdate();

            if(a == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }

    }
}
