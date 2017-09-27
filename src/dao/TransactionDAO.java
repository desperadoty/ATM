package dao;

import com.po.Transaction;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/3/9.
 * 与transaction表相关操作
 * 功能：
 * 1,添加取款记录
 * 2,添加存款记录
 */
public class TransactionDAO {

    //获取当前时间
    private static String getCurrentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now = new java.util.Date();
        return sdf.format(now);
    }

    //取款记录
    public boolean addDrawInfo(Transaction transaction) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int a = 0;
        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "INSERT INTO TRANSACTION(id,transtype,amount,transdate) VALUES(?,?,?,?);"; //SQL语句
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,transaction.getId());
            stmt.setString(2,transaction.getTranstype());
            stmt.setDouble(3,transaction.getAmount());
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
        }
        return flag;
    }

    //存款记录
    public boolean addDepositInfo(Transaction transaction) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int a = 0;
        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "INSERT INTO TRANSACTION(id,transtype,amount,transdate) VALUES(?,?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,transaction.getId());
            stmt.setString(2,transaction.getTranstype());
            stmt.setDouble(3,transaction.getAmount());
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
        }
        return flag;
    }
}
